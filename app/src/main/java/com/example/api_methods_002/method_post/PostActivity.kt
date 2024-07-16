package com.example.api_methods_002.method_post

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.api_methods_002.R
import com.example.api_methods_002.databinding.ActivityPostBinding
import com.example.api_methods_002.service_main.ApiConnection
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call

class PostActivity : AppCompatActivity() {

    /* Global Escope Variables */
    private lateinit var viewBinding: ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewBinding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /* Execution of Functions */
        globalLevelSettings()
        backToMainActivity()
        postMethod()
    }

    private fun postMethod() {

        val progressBar = findViewById<ProgressBar>(R.id.progressarBar_id)
        val textViewResponsePostId = viewBinding.textViewPostResponseIdId
        val textViewResponsePostUserId = viewBinding.textViewPostResponseUserIdId
        val textViewResponsePostTitle = viewBinding.textViewPostResponseTitleId
        val textViewResponsePosBody = viewBinding.textViewPostResponseBodyId
        val apiConnection = ApiConnection()
        val apiService = apiConnection.createService(ApiService::class.java)

        val postRequest = ModelPostRequest(
            title = "Gilmarcos Santos",
            body = "G.Santos@gmail.com",
            userId = 1987
        )

        progressBar.visibility = View.VISIBLE

        val call: Call<ModelPostResponse> = apiService.createPost(postRequest)
        call.enqueue(object : Callback<ModelPostResponse> {

            override fun onResponse(call: Call<ModelPostResponse>, response: Response<ModelPostResponse>) {

                progressBar.visibility = View.INVISIBLE

                if (response.isSuccessful) {

                    val postResponse = response.body()

                    println("Post criado com sucesso: $postResponse")

                    textViewResponsePostId.text = buildString {
                        append("ID = ")
                        append(postResponse?.id.toString())
                    }
                    textViewResponsePostUserId.text = buildString {
                        append("CPF = ")
                        append(postResponse?.userId.toString())
                    }
                    textViewResponsePostTitle.text = buildString {
                        append("Nome = ")
                        append(postResponse?.title)
                    }
                    textViewResponsePosBody.text = buildString {
                        append("E-Mail = ")
                        append(postResponse?.body)
                    }

                } else {
                    println("Erro na resposta: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ModelPostResponse>, t: Throwable) {
                println("Erro na requisição: ${t.message}")
            }
        })
    }

    private fun backToMainActivity() {

        val buttomBack = findViewById<MaterialButton>(R.id.button_navigateActivity_id)
        buttomBack.text = getString(R.string.back_main_activity)

        buttomBack.setOnClickListener {

            if (buttomBack.isClickable) {

                finish()
            }
        }
    }

    private fun globalLevelSettings() {
        val textViewTitle = findViewById<MaterialTextView>(R.id.textView_title_id)
        val textViewSubTitle = findViewById<MaterialTextView>(R.id.textView_subtitle_id)

        //recyclerViewGet = viewBinding.recyclerViewPostId
        textViewTitle.text = getString(R.string.post_method)
        textViewSubTitle.text = getString(R.string.api_data)
    }
}

