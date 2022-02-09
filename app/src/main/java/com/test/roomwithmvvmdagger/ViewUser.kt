package com.test.roomwithmvvmdagger

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.roomwithmvvmdagger.Adapter.UserAdapter
import com.test.roomwithmvvmdagger.Entity.User
import com.test.roomwithmvvmdagger.ViewModel.UserViewModel
import com.test.roomwithmvvmdagger.databinding.ActivityViewUserBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ViewUser : AppCompatActivity() {
    private lateinit var userAdapter: UserAdapter

    @Inject
    lateinit var userViewModel: UserViewModel
    lateinit var binding: ActivityViewUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        changeStatusColor(R.color.blue)
        initRecyclerView()
        viewUserList()
    }

    private fun viewUserList() {
        userViewModel.getUser.observe(this, Observer { response ->
            userAdapter.setUser(response as ArrayList<User>)
            Log.d("main", "$response")
        })
    }

    private fun initRecyclerView() {
        userAdapter = UserAdapter(this, ArrayList())
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ViewUser)
            adapter = userAdapter
        }
    }
}