package com.example.myposts2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentsAdapter(var context: Context, var userComments:List <Comments>):RecyclerView.Adapter<CommentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var itemView=LayoutInflater.from(context).inflate(R.layout.comment_layout_item,parent,false)
        return CommentViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentPost=userComments.get(position)
        holder.tvName.text=currentPost.name
        holder.tvTitle.text=currentPost.title
        holder.tvBody.text=currentPost.body


    }
    override fun getItemCount(): Int {
        return userComments.size
    }

}
class CommentViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    var tvName=itemView.findViewById<TextView>(R.id.tvNameC)
    var tvTitle=itemView.findViewById<TextView>(R.id.tvEmail)
    var tvBody=itemView.findViewById<TextView>(R.id.tvBodyComments)

}
