package com.test.roomwithmvvmdagger.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.roomwithmvvmdagger.Entity.User
import com.test.roomwithmvvmdagger.R
import com.test.roomwithmvvmdagger.databinding.EachRowBinding

class UserAdapter
 constructor(
    private val context:Context,
    private var userList:ArrayList<User>)
    : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding: EachRowBinding = EachRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user=userList[position]
        holder.binding.apply {
            tvName.text = user.name
            tvAddress.text = user.address
            tvPhoneNo.text = user.phoneNo
            tvEmail.text = user.email
        }
    }
    inner class UserViewHolder(val binding: EachRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun setUser(userList: ArrayList<User>){
        this.userList=userList
        notifyDataSetChanged()
    }
}