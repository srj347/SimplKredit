package org.example.simplkredit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.example.simplkredit.constants.VerificationStatus
import org.example.simplkredit.uistates.UiResponse
import org.example.simplkredit.uistates.UiState
import org.example.simplkredit.uistates.User

class OnboardingViewModel: ViewModel() {
    private val _userUiState = MutableLiveData<UiState<User>>()
    val userUiState: LiveData<UiState<User>> = _userUiState

    private val _phoneRegistrationState = MutableLiveData<UiState<Any>>()
    val phoneRegistrationState: LiveData<UiState<Any>> = _phoneRegistrationState

    private val _phoneVerificationStatus = MutableLiveData<VerificationStatus>()
    val phoneVerificationStatus: LiveData<VerificationStatus> = _phoneVerificationStatus

    fun sendOtp(phoneNumber: String){
        _phoneVerificationStatus.value = VerificationStatus.OtpSent
    }

    fun verifyOtp(userOtp: String) {
        if(userOtp == "1234"){
            _phoneVerificationStatus.value = VerificationStatus.OtpVerified
        }
        else{
            _phoneVerificationStatus.value = VerificationStatus.OtpVerificationFailed
        }
    }
}