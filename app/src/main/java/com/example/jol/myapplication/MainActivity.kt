package com.example.jol.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
    }

    fun getDetails(view: View) {
        val username = findViewById<EditText>(R.id.username);
        val password = findViewById<EditText>(R.id.password);
        if (username.text.toString() == "blah" && password.text.toString() == "blah") {
            val myToast = Toast.makeText(this, "logged in", Toast.LENGTH_SHORT);
            myToast.show();
        }
        val intent = Intent(this, Home::class.java);
        startActivity(intent);
    }
}
