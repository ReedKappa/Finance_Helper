package com.example.financehelper.presenter.main_package.root_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financehelper.domain.IsOnboardingRequiredUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class RootViewModel @Inject constructor(
    isOnboardingRequiredUseCase: IsOnboardingRequiredUseCase
): ViewModel() {

    private val _isRequired = MutableLiveData<Boolean>()
    val isRequired: LiveData<Boolean>
        get() = _isRequired

    init {
        viewModelScope.launch {
            isOnboardingRequiredUseCase().collect {
                _isRequired.postValue(it)
            }
        }
    }
}