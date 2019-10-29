package com.github.aakira.mpp.common.model

import kotlinx.serialization.Serializable

@Serializable
data class Greeting(
    val hello: String,
    val bye: String
)
