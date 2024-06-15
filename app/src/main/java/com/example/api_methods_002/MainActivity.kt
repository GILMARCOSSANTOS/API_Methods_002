package com.example.api_methods_002

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.api_methods_002.databinding.ActivityMainBinding
import com.example.api_methods_002.get.GetActivity

class MainActivity : AppCompatActivity() {

    /* Global Escope Variables */
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /* Perform the Functions */
        followButton()
    }

    private fun followButton(){

        val buttonFollow = viewBinding.buttonNavigateToGetActivityId

        buttonFollow.setOnClickListener{

            if (buttonFollow.isClickable){

                val intent = Intent(this, GetActivity::class.java ).apply {

                }

                startActivity(intent)
            }
        }
    }
}