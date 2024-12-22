package com.example.myapplication

import android.content.Context

class MainTextFormatter(private val applicationContext:Context) {
    fun getCounterText(cout: Int) = applicationContext.getString(R.string.total_request_count,cout)
}