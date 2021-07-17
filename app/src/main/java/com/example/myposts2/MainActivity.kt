package com.example.myposts2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPosts()
    }
    private fun getPosts() {
        var rvPosts=findViewById<RecyclerView>(R.id.rvPosts)
        val retrofit = ApiClient.buildApiClient(API_Interface::class.java)
        val request = retrofit.getPosts()
        request.enqueue(object : Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful){
                    var posts= response.body()
                    Toast.makeText(baseContext,posts?.size.toString() ,Toast.LENGTH_LONG).show()
                    val postsAdapter=PostsAdapter(baseContext, posts!!)
                    rvPosts.adapter=postsAdapter
                    rvPosts.layoutManager=LinearLayoutManager(baseContext)

                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }


        }
        )

    }
}
