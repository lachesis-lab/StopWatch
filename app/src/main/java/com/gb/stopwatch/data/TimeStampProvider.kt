package com.gb.stopwatch.data

internal interface TimestampProvider {
    fun getMilliseconds(): Long
}
