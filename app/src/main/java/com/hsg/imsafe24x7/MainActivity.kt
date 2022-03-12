package com.hsg.imsafe24x7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var logout_btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logout_btn = findViewById(R.id.logout_btn)

        logout_btn.setOnClickListener {
            FirebaseAuth.getInstance().signOut().also {
                val intent = Intent(this, Login_screen::class.java)
                startActivity(intent)
            }
        }
        send_location_card.setOnClickListener {
            val intent = Intent(this,LocationPage::class.java)
            startActivity(intent)
        }

        var database = FirebaseAuth.getInstance()

    }
}