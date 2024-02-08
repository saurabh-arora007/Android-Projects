package com.example.bechdo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerView = findViewById(R.id.rv_activity_home)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getProductData()
        retrofitData.enqueue(object : Callback<MyData> {
            override fun onResponse(call: Call<MyData>, response: Response<MyData>) {
                // Call on success
                var responseBody = response.body()
                val productArray = responseBody?.products!!
                Log.d("HomeActivity onSuccess()", "onResponse: $productArray")
                myAdapter = MyAdapter(this@HomeActivity, productArray)
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@HomeActivity)
            }

            override fun onFailure(call: Call<MyData>, t: Throwable) {
                // Call on failure
                Log.d("HomeActivity onFailure()", "onFailure: "+t.message)

            }
        })
    }
}