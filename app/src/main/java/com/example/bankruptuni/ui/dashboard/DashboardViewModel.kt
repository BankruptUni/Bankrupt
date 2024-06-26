package com.example.bankruptuni.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Cheque as estações mais próximas! "
    }
    val text: LiveData<String> = _text
}