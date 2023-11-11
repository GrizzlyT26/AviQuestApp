package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()

        binding.button.setOnClickListener{
            val signupEmail = binding.signupEmails.text.toString()
            val signupPassword = binding.signupPass.text.toString()

            if(signupEmail.isNotEmpty() && signupPassword.isNotEmpty()){
                signUp(signupEmail, signupPassword)
            } else {
                Toast.makeText(this@SignUp, "All fields are mandatory..", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLogRegister.setOnClickListener {
            startActivity(Intent(this@SignUp, Login::class.java))
        }
    }

    private fun signUp(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this@SignUp, "SignUp successfully..", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SignUp, Login::class.java))
                    finish()
                } else {
                    val errorMessage = task.exception?.message
                    Toast.makeText(this@SignUp, "Authentication failed: $errorMessage", Toast.LENGTH_SHORT).show()
                }
            }
    }

}
