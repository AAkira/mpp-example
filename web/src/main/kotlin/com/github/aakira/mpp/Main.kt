package com.github.aakira.mpp

import com.github.aakira.mpp.common.ApiClient
import com.github.aakira.napier.DebugAntilog
import com.github.aakira.napier.Napier
import kotlin.browser.document

fun main() {
    Napier.base(DebugAntilog("napier js"))

    ApiClient().getGreeting(
        successCallback = {
            document.body?.textContent = it.hello
        },
        errorCallback = {
            console.log(it.toString())
        }
    )
}
