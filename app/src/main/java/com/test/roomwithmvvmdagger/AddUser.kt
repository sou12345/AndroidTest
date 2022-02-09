package com.test.roomwithmvvmdagger

import android.content.Context
import android.os.Bundle
import android.util.Patterns
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.test.roomwithmvvmdagger.Entity.User
import com.test.roomwithmvvmdagger.ViewModel.UserViewModel
import com.test.roomwithmvvmdagger.databinding.ActivityAddUserBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AddUser : AppCompatActivity() {
    @Inject
    lateinit var userViewModel: UserViewModel
    lateinit var binding: ActivityAddUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        changeStatusColor(R.color.blue)
        binding.btnSave.setOnClickListener {
            saveUser()
        }
    }

    private fun saveUser() {
        binding.apply {
            val getName = edName.text.toString().trim()
            val getAddress = edAddress.text.toString().trim()
            val getPhoneNo = edPhoneNo.text.toString().trim()
            val getEmail = edEmail.text.toString().trim()
            when {
                getName.isEmpty() -> {
                    snackBar("Please Enter Your Name", "", binding.constrainLayout)
                }
                getAddress.isEmpty() -> {
                    snackBar("Please Enter Your Address", "", binding.constrainLayout)
                }
                getPhoneNo.isEmpty() -> {
                    snackBar("Please Enter Your Phone No", "", binding.constrainLayout)
                }
                getPhoneNo.length != 10 -> {
                    snackBar("Please Check Your Phone No", "", binding.constrainLayout)
                }
                getEmail.isEmpty() -> {
                    snackBar("Please Enter Your Email", "", binding.constrainLayout)
                }
                !getEmail.isValidEmail() -> {
                    snackBar("Please Check Your Email", "", binding.constrainLayout)
                }
                else -> {
                    val user = User(getName, getAddress, getPhoneNo, getEmail)
                    userViewModel.insert(user)
                    val imm: InputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(binding.constrainLayout.getWindowToken(), 0)
                    snackBar("Insert Successfully", "", binding.constrainLayout)
                }
            }
        }
    }

    fun CharSequence?.isValidEmail() =
        !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}