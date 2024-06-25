package com.example.bankruptuni

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bankruptuni.api.ApiProtocols
import com.example.bankruptuni.api.GetRetornoObj
import com.example.bankruptuni.data.Usuario
import com.example.bankruptuni.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity() {
    private lateinit var _binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        val button: Button = findViewById(R.id.button2)

        button.setOnClickListener {
            val usrLogin = if(_binding.editTextText.text.length > 0)
                                _binding.editTextText.text.toString()
                            else ""
            val usrPasswd = if(_binding.editTextNumberPassword.text.length > 0)
                                _binding.editTextNumberPassword.text.toString()
                            else ""

            val retorno = getLogin(usrLogin, usrPasswd,this)
            if(retorno != null && retorno.ok) {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("user", retorno.objeto)
                startActivity(intent)
            }
            else {
                val msg ="Usuário não reconhecido na base de dados!"
                Toast
                    .makeText(this, msg, Toast.LENGTH_SHORT)
                    .show()

                _binding.editTextText.text.clear()
                _binding.editTextNumberPassword.text.clear()
            }

            //  /---    previous interaction    ---/
            //  if(usrLogin == "bankrupt" && usrPasswd == "teste" ) {
            //  }
            //
        }
    }
    fun getLogin(user: String, password: String, context: Context): GetRetornoObj<Usuario>? {
        val url = "https://192.168.1.19:7561/getLogin"
        return ApiProtocols<Usuario>().loginApi(url, user, password, context)
    }
}