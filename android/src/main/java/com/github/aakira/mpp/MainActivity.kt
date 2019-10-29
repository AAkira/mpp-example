package com.github.aakira.mpp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.github.aakira.mpp.common.ApiClient
import com.github.aakira.mpp.common.GreetingDao
import com.github.aakira.mpp.common.mppAppContext
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ApiClient().getGreeting(
            successCallback = {
                handler.post { helloText.text = it.hello }
            },
            errorCallback = {
                handler.post { helloText.text = it.toString() }
            })

        mppAppContext = applicationContext
        val dao = GreetingDao()

        var index = 0
        addButton.setOnClickListener {
            dao.storeGreeting("hello: $index", "bye")
            index++
        }
        checkButton.setOnClickListener {
            val greetings = dao.getGreetings()
            greetings.forEach {
                Log.v("Greeting", "${it.hello}")
            }
        }
        val greetings = dao.getGreetingsFlow()
        lifecycleScope.launch {
            greetings.collect { query ->
                query.executeAsList().forEach {
                    Log.v("Greeting Flow", it.hello)
                }
            }
        }
    }
}
