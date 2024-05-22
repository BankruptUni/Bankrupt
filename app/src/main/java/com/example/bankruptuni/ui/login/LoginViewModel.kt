package com.example.bankruptuni.ui.login

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val texts : Map<String, String> =
        mapOf("user" to "Usuário", "passwd" to "senha", "text" to "Sem conta? Crie agora!")
    private val user : String = "${texts["user"]}"
    private val passwd : String = "${texts["passwd"]}"
    private val text : String = "${texts["senha"]}"
    }
