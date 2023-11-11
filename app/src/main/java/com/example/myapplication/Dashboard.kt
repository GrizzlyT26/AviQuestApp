package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityDashboardBinding
import com.example.myapplication.databinding.ActivityLoginBinding

class Dashboard : AppCompatActivity(){
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView46.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.imageView48.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.imageView40.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.imageView411.setOnClickListener {
            startActivity(Intent(this, MainActivity1::class.java))
        }
        binding.imageView47.setOnClickListener {
            startActivity(Intent(this, Settings::class.java))
        }
        binding.imageView512.setOnClickListener {
            startActivity(Intent(this, Settings::class.java))
        }
        binding.imageView513.setOnClickListener {
            startActivity(Intent(this, MainActivity1::class.java))
        }
        binding.imageView514.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.profile.setOnClickListener {
            startActivity(Intent(this, Settings::class.java))
        }
    }
}