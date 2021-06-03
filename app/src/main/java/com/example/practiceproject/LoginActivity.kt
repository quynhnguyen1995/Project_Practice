package com.example.practiceproject

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            if (edtName.equals("") || edtPassword.equals("")) {
                txtError1.text = "Please enter your username or password"
                txtError2.text = "Please enter your username or password"
            } else {
                if (edtName.equals("patricklagger") && edtPassword.equals("31121995")) {
                    val intent: Intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Message!!")
                    builder.setMessage("Username or Password incorrect!!")
                    builder.setPositiveButton("Close") { dialogInterface, which ->
                        finish()
                    }
                }
            }
        }
    }
}