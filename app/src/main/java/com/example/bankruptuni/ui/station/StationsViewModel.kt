package com.example.bankruptuni.ui.station

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StationsViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply{
        value = "Select the station you want to manage."
    }
    val text: LiveData<String> = _text
}