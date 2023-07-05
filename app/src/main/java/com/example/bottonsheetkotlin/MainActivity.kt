package com.example.bottonsheetkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonclick=findViewById<Button>(R.id.buttonclick);

        buttonclick.setOnClickListener {

            val bsf = kotlinfragment();
//            supportFragmentManager.beginTransaction().replace(R.id.maincontainer,kotlinfragment()).commit();
            bsf.show(supportFragmentManager, bsf.tag)

        }

    }
}