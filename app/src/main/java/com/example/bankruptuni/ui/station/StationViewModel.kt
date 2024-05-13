package com.example.bankruptuni.ui.station

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StationViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply{
        value = "This is the Station Fragment"
    }
    val text: LiveData<String> = _text
}