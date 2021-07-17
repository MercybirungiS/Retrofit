package com.example.myposts2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface API_Interface {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("posts/{POST_ID}")
    fun getPosts(@Path("POST_ID")id:Int) : Call<Post>
    abstract fun getComment(postId: Int): Any

  @GET("posts/{POST_ID}/Comments")
  fun getComments(@Path("POST_ID")id:Int) : Call<List<Comments>>


}