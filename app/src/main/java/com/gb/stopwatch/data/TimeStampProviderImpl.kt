package com.gb.stopwatch.data

import com.gb.stopwatch.view.TimestampProvider

internal class TimeStampProviderImpl: TimestampProvider {
    override fun getMilliseconds(): Long {
        return System.currentTimeMillis()

    }
}