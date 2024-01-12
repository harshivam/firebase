package com.example.database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Signin : AppCompatActivity() {
    companion object{
        const val KEY1 =  "com.example.database.Signin.mail"
        const val KEY2 =  "com.example.database.Signin.name"
        const val KEY3 =  "com.example.database.Signin.id"
    }
    private lateinit var databaseReference:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        val signin = findViewById<Button>(R.id.btnSignin)
        val username = findViewById<TextInputEditText>(R.id.tvUid)






        fun readData(uniqueID:String){
            databaseReference = FirebaseDatabase.getInstance().getReference("users")
            databaseReference.child(uniqueID).get().addOnSuccessListener {
                if(it.exists()){
                    //welcome user user intent

                    val mail = it.child("email").value
                    val name = it.child("name").value
                    val username = it.child("id").value

                    val intentwelcome = Intent(this,HomeActivity::class.java)
                    intentwelcome.putExtra(KEY1,mail.toString())
                    intentwelcome.putExtra(KEY2,name.toString())
                    intentwelcome.putExtra(KEY3,username.toString())

                    startActivity(intentwelcome)

                }else{
                    Toast.makeText(this,"User does not exist,Sign up first",Toast.LENGTH_SHORT).show()

                }
            }.addOnFailureListener {
                Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show()
            }
        }

       fun fieldChecker(field:String){
            if(field.isNotEmpty()){
                readData(field)

            }else{
                Toast.makeText(this,"Please fill  the field",Toast.LENGTH_SHORT).show()
            }

        }
        signin.setOnClickListener {
            val uniqueID = username.text.toString()
            fieldChecker(uniqueID)
        }


    }
}