package org.example.simplkredit.uistates

sealed interface UiState<out T>{
    object Loading: UiState<Nothing>
    data class Success<T>(val response: UiResponse<T>?): UiState<T>
    data class Error(val message: String): UiState<Nothing>
}