package com.example.myposts2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class PostsAdapter (var context: Context, var userlist:List<Post>):RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
    var itemView=LayoutInflater.from(context).inflate(R.layout.lay_out_resource_file,parent,false)
        return PostViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPost=userlist.get(position)
        holder.tvId.text=currentPost.Id.toString()
        holder.tvTitle.text=currentPost.title
        holder.tvBody.text=currentPost.body
        holder.cvPost.setOnClickListener {
            var intent=Intent(context,CommentsActivity ::class.java)
            intent.putExtra("POST_ID", currentPost.Id)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return userlist.size
    }

}
class PostViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    var tvId=itemView.findViewById<TextView>(R.id.tvId)
    var tvTitle=itemView.findViewById<TextView>(R.id.tvTitle)
    var tvBody=itemView.findViewById<TextView>(R.id.tvBody)
    var cvPost=itemView.findViewById<CardView>(R.id.cvPosts)
}
