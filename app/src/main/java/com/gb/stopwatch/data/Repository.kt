package com.gb.stopwatch.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class Repository(dataSource: DataSource = DataSource()) {

    val data: Flow<Time> =
        dataSource.data.map { data -> Time(data) }
    //.onEach { saveInCache(it) }
}
/*
 class Repository(dataSource: DataSource = DataSource()) {

  val data: Flow<Time> =
   dataSource.data.map { time -> Time(time) }
}
*/
