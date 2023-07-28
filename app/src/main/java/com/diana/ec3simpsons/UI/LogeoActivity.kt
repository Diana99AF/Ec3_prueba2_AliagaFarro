package com.diana.ec3simpsons.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.diana.ec3simpsons.R
import com.diana.ec3simpsons.databinding.ActivityLogeoBinding

class LogeoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogeoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLogeoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.txtemail.editText?. addTextChangedListener {text ->
            validandoEntrada()
        }
        binding.txtpassword.editText?. addTextChangedListener {text ->
            validandoEntrada()
        }

        //Boton login
        binding.btnlogin.setOnClickListener {
            val email = binding.txtemail.editText?.text.toString()
            val password = binding.txtpassword.editText?.text.toString()

            if (validacionCorreoPass(email, password)) {
                val vmenu = Intent(this, MainActivity::class.java)
                startActivity(vmenu)
                Toast.makeText(this, "Ingresando...", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Los Datos ingresados no son los correctos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validandoEntrada() {
        val email = binding.txtemail.editText?.text.toString()
        val password = binding.txtpassword.editText?.text.toString()
        val validandoemail = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val validandopass = password.length >= 6
        binding.btnlogin.isEnabled = validandopass && validandoemail
    }

    private fun validacionCorreoPass(email:String,pass:String):Boolean{
        return email == "ejemplo@idat.edu.pe" && pass == "123456"
    }
}