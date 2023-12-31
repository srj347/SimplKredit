package org.example.simplkredit.uistates

data class UiResponse<T>(
    val data: T?,
    val tag: String
)
