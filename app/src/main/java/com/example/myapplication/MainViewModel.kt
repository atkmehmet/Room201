package com.example.myapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.jvm.Throws

@HiltViewModel
class MainViewModel @Inject constructor (
                     private val userService: UserService
                    ,private val dao: UserDao
                    ,private val mainTextFormatter: MainTextFormatter):ViewModel() {

    //var resulState by mutableStateOf<List<User>>(emptyList())
    var resulState by mutableStateOf<List<UserEntity>>(emptyList())
      private set

    private val _uiStateLiveData = MutableLiveData("")
    val uiStateLiveData :LiveData<String> = _uiStateLiveData
    init {
        try {

          //  viewModelScope.launch {
            //    val users = userService.getUsers()
             //   resulState = users
            //}
         viewModelScope.launch {
             flow {
                 emit(userService.getUsers())
             }.onEach {
                 val userEntities = it.map { user ->
                     UserEntity(
                         user.id, user.name, user.username, user.username
                     )
                 }
                 dao.insert(userEntities)
             }.flatMapConcat { dao.getAll() }
                 .catch {
                     emitAll(dao.getAll())
                 }.flowOn(Dispatchers.IO)
                 .collect { resulState = it }
         }
        }
        catch (e:Exception){
            throw IllegalStateException(e.message)
        }
    }

}
//class MainViewFactory:ViewModelProvider.Factory {
  //  override fun <T : ViewModel> create(modelClass: Class<T>): T = MainViewModel(MyApplication.service,MyApplication.userDao,MyApplication.mainTextFormatter) as T
//}
