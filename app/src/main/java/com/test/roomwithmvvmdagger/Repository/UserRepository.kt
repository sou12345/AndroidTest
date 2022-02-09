package com.test.roomwithmvvmdagger.Repository

import androidx.annotation.WorkerThread
import com.test.roomwithmvvmdagger.Dao.UserDao
import com.test.roomwithmvvmdagger.Entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor (private val userDao: UserDao) {
    val getUser:Flow<List<User>> = userDao.getUser()

    @WorkerThread
    suspend fun insert(user: User) = withContext(Dispatchers.IO){
        userDao.insert(user)
    }
}