package com.gb.stopwatch.viewmodel

import androidx.lifecycle.*
import com.gb.stopwatch.data.*
import com.gb.stopwatch.data.TimeStampProviderImpl
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

internal class MainViewModel(
    timestampProvider: TimestampProvider = TimeStampProviderImpl(),
) : ViewModel() {

    val liveData: MutableLiveData<String?> = MutableLiveData()
    private val interactor = MainInteractor(timestampProvider,viewModelScope)

    init {
        viewModelScope.launch {
            CoroutineScope(
                Dispatchers.Main
                        + SupervisorJob()
            ).launch {
                interactor.ticker.collect {
                    liveData.value = it
                }
            }

        }
    }

    fun start() {
        interactor.start()
    }

    fun pause() {
        interactor.pause()
    }

    fun stop() {
        interactor.stop()
    }


}

