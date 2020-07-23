package com.mayokunadeniyi.data.common.coroutine

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 * Created by Mayokun Adeniyi on 23/07/2020.
 */

open class CoroutineContextProvider {
    open val main: CoroutineContext by lazy { Dispatchers.Main }
    open val io: CoroutineContext by lazy { Dispatchers.IO }
    open val default: CoroutineContext by lazy { Dispatchers.Default }
}

class TestCoroutineContextProvider : CoroutineContextProvider() {
    override val main: CoroutineContext = Dispatchers.Unconfined
    override val io: CoroutineContext = Dispatchers.Unconfined
    override val default: CoroutineContext = Dispatchers.Unconfined
}