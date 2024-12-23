package com.example.myapplication


import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences


private val KEY_COUNT = intPreferencesKey("key_count")
class AppDataStore(private val dataStore: DataStore<Preferences>) {


}