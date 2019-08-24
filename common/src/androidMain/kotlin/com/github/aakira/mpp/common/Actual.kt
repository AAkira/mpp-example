package com.github.aakira.mpp.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

// Androidのエミュレータはlocalhostが使えない
internal actual val hostName = "10.0.2.2"

internal actual val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
