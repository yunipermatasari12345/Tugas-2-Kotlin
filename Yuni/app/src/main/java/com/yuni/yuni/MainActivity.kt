package com.yuni.yuni

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val txtName= findViewById<EditText>(R.id.Nama)
        val txtPass = findViewById<EditText>(R.id.Password)
        val btnLogin = findViewById<Button>(R.id.Login)

        btnLogin.setOnClickListener(){
            val user = txtName.text.toString()
            val pass = txtPass.text.toString()

            if(user == "admin" && pass == "123456"){
                val intent = Intent(this, Welcome::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Username atau Password anda salah", Toast.LENGTH_SHORT).show()
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}