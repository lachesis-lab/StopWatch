package com.gb.stopwatch.data

import kotlinx.coroutines.flow.Flow

sealed class StopwatchState {

    data class Paused(
        val elapsedTime: Long
    ) : StopwatchState()

    data class Running(
        val startTime: Long,
        val elapsedTime: Long
    ) : StopwatchState()
}
