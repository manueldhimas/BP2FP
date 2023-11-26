package com.example.bp2fp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val txtName: EditText = findViewById(R.id.textNameRegis)
        val txtEmail: EditText = findViewById(R.id.textEmailRegis)
        val txtPass: EditText = findViewById(R.id.textPasswordRegis)

        val btnRegister: Button = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val databaseHelper = DatabaseHelper(this)
            val name:String = txtName.text.toString().trim()
            val email:String = txtEmail.text.toString().trim()
            val password:String = txtPass.text.toString().trim()

            val data:String = databaseHelper.checkData(email)

            if(data == ""){
                databaseHelper.addAccount(
                    email,name,password)

                val intentLogin = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intentLogin)
            } else {
                Toast.makeText(this@RegisterActivity,"Register Failed." + "Your Email arealdy registered", Toast.LENGTH_SHORT).show()
            }
        }
    }


}