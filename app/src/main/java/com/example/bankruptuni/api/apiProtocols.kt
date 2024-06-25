package com.example.bankruptuni.api

import android.content.Context
import android.os.AsyncTask
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.RetryPolicy
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.runBlocking
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class ApiProtocols<T> {
    fun loginApi(url:String, login:String, senha:String, context:Context): GetRetornoObj<T>? {
        /*val x: KeyStore = KeyStore.getInstance(KeyStore.getDefaultType())
        x.load(null,null)
        val certificate = Certificate()*/
        NukeSSLCerts().nuke()

        var retorno: GetRetornoObj<T>? = null
        val queue = Volley.newRequestQueue(context)

        val socketTimeout = 3000
        val policy: RetryPolicy = DefaultRetryPolicy(
            socketTimeout,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )
        var json = JSONObject.wrap(hashMapOf("login" to login, "senha" to senha))  as JSONObject
        AsyncTask.execute {
            val request = JsonObjectRequest(
                Request.Method.POST, url, json,
                { res ->
                    retorno =
                        Gson()
                            .fromJson<GetRetornoObj<T>>(res.toString(), object : TypeToken<T>() {}.type)
                },
                { error ->
                    print(error?.networkResponse.toString())
                },
            )
            request.setRetryPolicy(policy)
            queue.add(request)
        }
        return retorno
    }

    fun postApi(url:URL): PostRetornoObj<T>? {
        var retorno: PostRetornoObj<T>? = null
        val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
        runBlocking {
            connection.requestMethod = "POST"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.setRequestProperty("Accept", "application/json")
            connection.doOutput = true

            if(connection.responseCode == 200 || connection.responseCode == 201) {
                BufferedReader(
                    InputStreamReader(connection.inputStream, "utf-8")
                ).use { br ->
                    val response = StringBuilder()
                    var responseLine :String?
                   while (br.readLine().also { responseLine = it } != null) {
                        response.append(responseLine!!.trim { it <= ' ' })
                    }

                    retorno =
                        Gson()
                            .fromJson<PostRetornoObj<T>>(response.toString(), object: TypeToken<T>() {}.type)
                }
            }
            else {
                //end
            }
        }
        return retorno
    }

}