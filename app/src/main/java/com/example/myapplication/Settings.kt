package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityDashboardBinding
import com.example.myapplication.databinding.ActivitySettingsBinding

class Settings : AppCompatActivity(){
    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView1.setOnClickListener {
            startActivity(Intent(this, MainActivity1::class.java))
        }
        binding.imageView103.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
    }
}