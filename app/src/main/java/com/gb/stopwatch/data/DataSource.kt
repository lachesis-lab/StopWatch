package com.gb.stopwatch.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class DataSource(
    val timeStamp: TimeStampProviderImpl
) {
    val data: Flow<Long> = flow {
        val time = timeStamp.getMilliseconds()
        emit(time)
    }
        .flowOn(Dispatchers.Default)
        .catch { e -> println(e.message) }
}