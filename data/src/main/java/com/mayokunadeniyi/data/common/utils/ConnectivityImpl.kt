package com.mayokunadeniyi.data.common.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Mayokun Adeniyi on 23/07/2020.
 */

class ConnectivityImpl(private val context: Context) : Connectivity {

    override fun hasNetworkAccess(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivityManager.activeNetworkInfo
        return info != null && info.isConnected
    }
}