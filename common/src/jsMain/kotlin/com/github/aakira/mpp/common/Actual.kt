package com.github.aakira.mpp.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal actual val hostName = "localhost"

internal actual val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default

actual fun createDb(): GreetingDatabase? = null
