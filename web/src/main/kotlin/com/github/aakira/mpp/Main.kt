package com.github.aakira.mpp

import com.github.aakira.mpp.common.ApiClient
import kotlin.browser.document

fun main() {
    ApiClient().getGreeting(
        successCallback = {
            document.body?.textContent = it.hello
        },
        errorCallback = {
            console.log(it.toString())
        }
    )
}
