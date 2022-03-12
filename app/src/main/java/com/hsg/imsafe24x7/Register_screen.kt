package com.hsg.imsafe24x7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Register_screen : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var pwd: EditText
    lateinit var name: EditText
    lateinit var number: EditText
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)

        email = findViewById(R.id.email)
        pwd = findViewById(R.id.password)
        btn = findViewById(R.id.create_btn)
        number = findViewById(R.id.number)
        name = findViewById(R.id.Name)

        btn.setOnClickListener {
            val email_txt = email.text.toString().trim()
            val pwd_txt = pwd.text.toString().trim()
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email_txt,pwd_txt).addOnSuccessListener {
                Toast.makeText(this,"Welcome ${name.text}", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,"account creation unsuccessful try again", Toast.LENGTH_SHORT).show()
            }.addOnCompleteListener {
                    task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, Login_screen::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Unsuccessful try again", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}