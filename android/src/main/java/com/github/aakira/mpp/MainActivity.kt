package com.github.aakira.mpp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.github.aakira.mpp.common.ApiClient
import kotlinx.android.synthetic.main.activity_main.*

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
    }
}
