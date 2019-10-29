package com.github.aakira.mpp.server

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.http.HttpHeaders
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun Application.module() {
    install(DefaultHeaders) {
        // WEBブラウザからアクセスするために全ての通信を許可(CORS)
        header(HttpHeaders.AccessControlAllowOrigin, "*")
    }
    install(CallLogging)
    install(ContentNegotiation) {
        gson()
    }
    install(Routing) {
        get("/") {
            call.respond(
                com.github.aakira.mpp.common.model.Greeting(
                    "Hello World form server!",
                    "Bye bye."
                )
            )
        }
    }
}

fun main() {
    embeddedServer(
        Netty,
        8080,
        module = Application::module
    ).start()
}
