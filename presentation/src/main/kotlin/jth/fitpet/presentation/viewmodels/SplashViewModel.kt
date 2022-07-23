package jth.fitpet.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SplashViewModel : BaseViewModel() {
    private val _complete = MutableLiveData<Boolean>()
    val complete: LiveData<Boolean> get() = _complete

    init {
        _complete.value = false
    }

    fun updateComplete(){
        _complete.value = true
    }
}