package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val mail = intent.getStringExtra(Signin.KEY1)
        val name = intent.getStringExtra(Signin.KEY2)
        val id = intent.getStringExtra(Signin.KEY3)

        val welcomeText = findViewById<TextView>(R.id.textWelcome)
        val mailText = findViewById<TextView>(R.id.tvName)  // Correct variable name
        val idText = findViewById<TextView>(R.id.tvID)      // Correct variable name

        welcomeText.text = " Welcome $name"
        mailText.text = "Mail: $mail"   // Correct variable name
        idText.text = "UserID: $id"     // Correct variable name
    }
}
