package com.hsg.imsafe24x7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class Splash_Screen : AppCompatActivity() {

    lateinit var tv:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        tv = findViewById(R.id.tvGirl)

        tv.animate().translationY(-100f).duration = 1500

        if(FirebaseAuth.getInstance().currentUser != null){
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)

            },2000)
        }
        else{
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this,Login_screen::class.java)
                startActivity(intent)
            },2000)
        }
    }
}