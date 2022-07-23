package jth.fitpet.presentation.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

open class BaseViewModel : ViewModel() {
    val progress = MutableStateFlow(false)
    val progressFlow = progress.asStateFlow()

    val toast = MutableStateFlow("")
    val toastFlow = toast.asStateFlow()
}