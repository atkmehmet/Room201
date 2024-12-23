package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun UserList(users:List<UserEntity>,navController: NavController){

        LazyColumn(modifier = Modifier.padding(16.dp)) {

            items(users.size){
                    Column {
                        Text(text = users[it].name)
                        Text(text = users[it].surname)
                        Text(text = users[it].id.toString())
                    }
            }
        }


}