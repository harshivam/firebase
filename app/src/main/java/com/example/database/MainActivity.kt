package com.example.database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val signButton = findViewById<Button>(R.id.btnSignup)
        val etEmail = findViewById<TextInputEditText>(R.id.tvInput1)
        val etName = findViewById<TextInputEditText>(R.id.tvInput2)
        val etPass = findViewById<TextInputEditText>(R.id.tvInput3)
        val etid = findViewById<TextInputEditText>(R.id.tvInput4)
        val tvSignIN = findViewById<TextView>(R.id.tvSignIn)


        tvSignIN.setOnClickListener {
            val intent = Intent(this,Signin::class.java)
            startActivity(intent)
        }

         signButton.setOnClickListener {
             val name = etName.text.toString()
             val email = etEmail.text.toString()
             val pass = etPass.text.toString()
             val id = etid.text.toString()
            val user = user(name,email, pass,id )

             database = FirebaseDatabase.getInstance().getReference("users")
             database.child(id).setValue(user).addOnSuccessListener {
                 Toast.makeText(this,"User Registered",Toast.LENGTH_SHORT).show()
             }.addOnFailureListener{
                 Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
             }
         }

    }
}