package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class LoadScreen : AppCompatActivity() {
    //Code has yet to be added here//
    private val LoadScreen: Long = 5000 // 5 seconds
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_page)

        // Handler to navigate to the next activity after the splashTimeOut
        Handler().postDelayed({
            //the LoadScreen is where is the intent where you want to go//
            val intent = Intent(
                this,
                Login::class.java
            )
            startActivity(intent)
            finish()
        }, LoadScreen)
    }
}