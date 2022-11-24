package com.gb.stopwatch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gb.stopwatch.data.Repository
import com.gb.stopwatch.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

internal class MainViewModel( repository: Repository = Repository()): ViewModel(){
    val liveData: MutableLiveData<T> = MutableLiveData()

    private val stopwatchListOrchestrator = StopwatchListOrchestrator(
        StopwatchStateHolder(
            StopwatchStateCalculator(
                timestampProvider,
                ElapsedTimeCalculator(timestampProvider)
            ),
            ElapsedTimeCalculator(timestampProvider),
            TimestampMillisecondsFormatter()
        ),
        CoroutineScope(
            Dispatchers.Main
                    + SupervisorJob()
        )
    )

    init {
        viewModelScope.launch {

/*

            repository.userData.flowOn(Dispatchers.Main)
                //import kotlinx.coroutines.flow.collect
                .collect { data ->
                    liveData.value = data
                }
*/
        }
    }
}