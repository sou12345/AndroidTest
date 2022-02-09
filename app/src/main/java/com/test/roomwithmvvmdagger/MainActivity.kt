package com.test.roomwithmvvmdagger

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.roomwithmvvmdagger.ViewModel.UserViewModel
import com.test.roomwithmvvmdagger.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var userViewModel: UserViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        changeStatusColor(R.color.blue)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.apply {
            btnAddUser.setOnClickListener {
                startActivity(Intent(this@MainActivity, AddUser::class.java))
            }
            btnViewUser.setOnClickListener {
                startActivity(Intent(this@MainActivity, ViewUser::class.java))
            }
        }
    }
}