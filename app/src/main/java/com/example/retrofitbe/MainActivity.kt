package com.example.retrofitbe

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.retrofitbe.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val urlBase = "https://jsonplaceholder.typicode.com/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitObj = Retrofit.Builder()
            .baseUrl(urlBase)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofitObj.create(PostApiService::class.java)

        val obj = PostModelRequest(1, "Title nuevo", "Body nuevo")

        lifecycleScope.launch {
            val response = service.insertPost(obj)
            if (response.isSuccessful) {
                val post = response.body()
                binding.textView.text = "${post?.id} -> ${post?.title}" ?: "No title"
            } else {
                binding.textView.text = "Error: ${response.code()}"
            }

        }
    }
}