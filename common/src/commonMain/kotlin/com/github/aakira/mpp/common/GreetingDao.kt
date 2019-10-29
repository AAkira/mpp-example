package com.github.aakira.mpp.common

import com.github.aakira.mpp.common.model.Greeting
import com.squareup.sqldelight.Query
import com.squareup.sqldelight.runtime.coroutines.asFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal const val dbName: String = "greeting.db"

expect fun createDb(): GreetingDatabase?

class GreetingDao {

    private val greetingDatabase = createDb()
    private val queries = greetingDatabase?.greetingQueries

    fun storeGreeting(hello: String, bye: String) {
        queries?.insertItem(hello, bye)
    }

    fun getGreetings(): List<Greeting> {
        val queries = queries ?: return listOf()

        return queries.selectAll(mapper = { _, hello, bye ->
            Greeting(hello, bye)
        }).executeAsList()
    }

    fun getGreetingsFlow(): Flow<Query<Greeting>> {
        val queries = queries ?: return flowOf()

        return queries.selectAll(mapper = { _, hello, bye ->
            Greeting(hello, bye)
        }).asFlow()
    }
}

