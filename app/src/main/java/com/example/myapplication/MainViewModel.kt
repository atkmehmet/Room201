package com.example.myapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val userService: UserService,private val userDao: UserDao):ViewModel( ) {

    var resulState by mutableStateOf<List<User>>(emptyList())
      private set
    init {
        viewModelScope.launch {
            val users = userService.getUsers()
            resulState = users
        }
    }

}
class MainViewFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = MainViewModel(MyApplication.userService,MyApplication.userDao) as T
}