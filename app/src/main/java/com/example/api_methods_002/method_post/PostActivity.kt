package com.example.api_methods_002.method_post

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.api_methods_002.R
import com.example.api_methods_002.databinding.ActivityGetBinding
import com.example.api_methods_002.databinding.ActivityPostBinding
import com.example.api_methods_002.method_post.model.BodyPost
import com.example.api_methods_002.method_post.service.ApiService
import com.example.api_methods_002.service_main.ApiConnection
import com.example.api_methods_002.service_main.ApiInitialConfig
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostActivity : AppCompatActivity() {

    /* Global Escope Variables */
    private lateinit var viewBinding: ActivityPostBinding
    private lateinit var recyclerViewGet: RecyclerView
    private lateinit var apiService: ApiService

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

        // Inicializa a conexão com a API
        val apiConnection = ApiConnection()
        apiService = apiConnection.createService(ApiService::class.java)

        // Cria um novo usuário
        val user = BodyPost(343434, 434343, "password123", "sddsd", "sdsds")
        createUser(user)
    }

    private fun createUser(user: BodyPost) {
        apiService.postUser(user).enqueue(object : Callback<BodyPost> {
            override fun onResponse(call: Call<BodyPost>, response: Response<BodyPost>) {
                if (response.isSuccessful) {
                    // Sucesso, faça algo com a resposta
                    val createdUser = response.body()
                    // Por exemplo, exiba uma mensagem
                    println("Usuário criado: ${createdUser?.name}")
                } else {
                    // Erro na resposta
                    println("Erro: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<BodyPost>, t: Throwable) {
                // Falha na chamada
                println("Falha: ${t.message}")
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

            recyclerViewGet = viewBinding.recyclerViewPostId
            textViewTitle.text = getString(R.string.post_method)
            textViewSubTitle.text = getString(R.string.api_data)
        }
    }