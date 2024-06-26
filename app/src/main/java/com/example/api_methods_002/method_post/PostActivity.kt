package com.example.api_methods_002.method_post

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
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
    private lateinit var recyclerViewGet: RecyclerView

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
        main()

    }

    fun main() {

        val textViewResponsePostId = viewBinding.textViewPostResponseIdId
        val textViewResponsePostUserId = viewBinding.textViewPostResponseUserIdId
        val textViewResponsePostTitle = viewBinding.textViewPostResponseTitleId
        val textViewResponsePosBody = viewBinding.textViewPostResponseBodyId
        val apiConnection = ApiConnection()
        val apiService = apiConnection.createService(ApiService::class.java)

        val postRequest = PostRequest(
            title = "Gilmarcos Santos",
            body = "G.Santos@gmail.com",
            userId = 1987
        )

        val call: Call<PostResponse> = apiService.createPost(postRequest)
        call.enqueue(object : Callback<PostResponse> {
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
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

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
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