package com.gb.stopwatch.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.gb.stopwatch.R
import com.gb.stopwatch.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.text_time)
        val buttonStart = findViewById<TextView>(R.id.button_start)
        val buttonPause= findViewById<TextView>(R.id.button_pause)
        val buttonStop = findViewById<TextView>(R.id.button_stop)
        val viewModel: MainViewModel by lazy {
            ViewModelProvider(this).get(MainViewModel::class.java)
        }
        viewModel.liveData.observe(
            this
        ) { timeStamp ->
            textView.text = timeStamp.toString()
        }
        buttonStart.setOnClickListener { viewModel.start() }
        buttonPause.setOnClickListener { viewModel.pause() }
        buttonStop.setOnClickListener { viewModel.stop() }
    }


}
