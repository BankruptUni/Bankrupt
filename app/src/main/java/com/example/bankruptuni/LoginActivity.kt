package com.example.bankruptuni

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.bankruptuni.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity() {
    private lateinit var _binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val button: Button = findViewById(R.id.button2)

        button.setOnClickListener {
            val usrLogin = _binding.editTextText.text.toString()
            val usrPasswd = _binding.editTextNumberPassword.text.toString()

            if(usrLogin == "bankrupt" && usrPasswd == "teste" ) {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}