package com.github.aakira.mpp.common

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

// Androidのエミュレータはlocalhostが使えない
internal actual val hostName = "10.0.2.2"

internal actual val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO

lateinit var mppAppContext: Context

actual fun createDb(): GreetingDatabase? =
    GreetingDatabase(AndroidSqliteDriver(GreetingDatabase.Schema, mppAppContext, dbName))
