package com.hsg.imsafe24x7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login_screen : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var pwd: EditText
    lateinit var btn: Button
    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        email = findViewById(R.id.email)
        pwd = findViewById(R.id.password)
        btn = findViewById(R.id.login_btn)
        text = findViewById(R.id.move_screen)

        text.setOnClickListener{
            val intent = Intent(this, Register_screen::class.java)
            startActivity(intent)
        }
        btn.setOnClickListener {
            val email_txt = email.text.toString().trim()
            val pwd_txt = pwd.text.toString().trim()
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email_txt, pwd_txt)
                .addOnSuccessListener {
                    Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                Toast.makeText(this, "Login unsuccessful try again", Toast.LENGTH_SHORT).show()
            }.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Login unsuccessful try again", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}