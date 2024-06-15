package com.example.api_methods_002

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.api_methods_002.databinding.ActivityMainBinding
import com.example.api_methods_002.get.GetActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {

    /* Global Level Variables */
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

        /* Execute the Functions */
        globalLevelSettings()
        followButton()
    }

    private fun followButton() {

        val buttonFollow = findViewById<MaterialButton>(R.id.button_navigateActivity_id)
        buttonFollow.text = "Método GET"

        buttonFollow.setOnClickListener {

            if (buttonFollow.isClickable) {

                val intent = Intent(this, GetActivity::class.java).apply {

                }

                startActivity(intent)
            }
        }
    }

    private fun globalLevelSettings() {

        val textViewSubTitle = findViewById<MaterialTextView>(R.id.textView_subtitle_id)
        val textViewTitle = findViewById<MaterialTextView>(R.id.textView_title_id)

        textViewTitle.text = getString(R.string.initial_screen)
        textViewSubTitle.text = getString(R.string.subtitle_main)
    }
}