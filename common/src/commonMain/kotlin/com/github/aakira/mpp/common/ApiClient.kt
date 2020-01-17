package com.github.aakira.mpp.common

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

internal expect val hostName: String
internal expect val coroutineDispatcher: CoroutineDispatcher

class ApiClient {
    private val httpClient = HttpClient()

    fun getGreeting(successCallback: (Greeting) -> Unit, errorCallback: (Exception) -> Unit) {
        GlobalScope.launch(coroutineDispatcher) {
            try {
                val result = httpClient.get<String> {
                    url {
                        protocol = URLProtocol.HTTP
                        host = hostName // expect value
                        port = 8080
                    }
                }
                val greeting = Json.parse(Greeting.serializer(), result)
                successCallback(greeting)
            } catch (e: Exception) {
                errorCallback(e)
            }
        }
    }
}
