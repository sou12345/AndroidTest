package com.test.roomwithmvvmdagger.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.test.roomwithmvvmdagger.Entity.User
import com.test.roomwithmvvmdagger.Repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel
@Inject
constructor(private val userRepository: UserRepository) : ViewModel() {
    val getUser: LiveData<List<User>>
        get() =
            userRepository.getUser.flowOn(Dispatchers.Main)
                .asLiveData(context = viewModelScope.coroutineContext)

    fun insert(user: User) {
        viewModelScope.launch {
            userRepository.insert(user)
        }
    }
}