package com.example.bp2fp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnlogin: Button = findViewById(R.id.btnLogin)
        val txtbtnregis: TextView = findViewById(R.id.txtBtnRegister)

        val txtEmail:EditText = findViewById(R.id.textEmail)
        val txtPass:EditText = findViewById(R.id.textPassword)

        txtbtnregis.setOnClickListener {
            val intentregis = Intent(this, RegisterActivity::class.java)
            startActivity(intentregis)
        }

        btnlogin.setOnClickListener {

            val databaseHelper = DatabaseHelper(this)

//            val data:String = databaseHelper.checkData("dhimasaya@gmail.com")
//            Toast.makeText(this@LoginActivity, "Result : " + data, Toast.LENGTH_SHORT).show()
//
//            if (data == null){
//            }

//            databaseHelper.addAccount("dhimasaya@gmail.com", "Dhimas Akhyar", "1234")

            val email = txtEmail.text.toString().trim()
            val  password = txtPass.text.toString().trim()

            val result:Boolean = databaseHelper.checkLogin(email,password)
            if (result == true){
                Toast.makeText(this@LoginActivity, "Login Success",
                    Toast.LENGTH_SHORT).show()
                val intentlogin = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intentlogin)


            } else {
                Toast.makeText(this@LoginActivity, "Login Failed, Try Again",
                    Toast.LENGTH_SHORT).show()

            }
        }
    }
}