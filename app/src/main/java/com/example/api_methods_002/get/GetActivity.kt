package com.example.api_methods_002.get

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.api_methods_002.R
import com.example.api_methods_002.databinding.ActivityGetBinding
import com.google.android.material.textview.MaterialTextView

class GetActivity : AppCompatActivity() {

    /* Global Escope Variables */
    private lateinit var viewBinding: ActivityGetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        viewBinding = ActivityGetBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /* Execution of Functions */
        globalLevel()
    }

    private fun globalLevel (){

        val textViewTitle = findViewById<MaterialTextView>(R.id.textView_screenTitle_id)
        textViewTitle.text = getString(R.string.get_method)
    }
}