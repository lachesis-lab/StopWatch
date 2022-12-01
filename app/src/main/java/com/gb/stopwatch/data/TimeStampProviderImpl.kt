package com.gb.stopwatch.data


internal class TimeStampProviderImpl(): TimestampProvider {
    override fun getMilliseconds(): Long {
        return System.currentTimeMillis()

    }
}