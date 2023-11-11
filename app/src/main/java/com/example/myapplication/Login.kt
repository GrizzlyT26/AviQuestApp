package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()

        binding.btnRegLogin.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }

        binding.button.setOnClickListener {
            val signinEmail = binding.signInEmail.text.toString()
            val signinPassword = binding.signInPassword.text.toString()

            if (signinEmail.isNotEmpty() && signinPassword.isNotEmpty()) {
                login(signinEmail, signinPassword)
            } else {
                Toast.makeText(this, "All fields are mandatory..", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun login(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this@Login, "SignIn successfully..", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@Login, Dashboard::class.java))
                    finish()
                } else {
                    // If sign in fails, display a message to the user.
                    when (task.exception) {
                        is FirebaseAuthInvalidUserException,
                        is FirebaseAuthInvalidCredentialsException -> {
                            Toast.makeText(this@Login, "Invalid email or password.", Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            Toast.makeText(this@Login, "Authentication failed.", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
    }
}
