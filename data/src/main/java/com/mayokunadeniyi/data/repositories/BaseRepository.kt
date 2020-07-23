package com.mayokunadeniyi.data.repositories

import com.mayokunadeniyi.data.common.coroutine.CoroutineContextProvider
import com.mayokunadeniyi.data.common.utils.Connectivity
import com.mayokunadeniyi.data.common.utils.Constants.DB_ENTRY_ERROR
import com.mayokunadeniyi.data.common.utils.Constants.GENERAL_NETWORK_ERROR
import com.mayokunadeniyi.data.remote.response.DomainMapper
import com.mayokunadeniyi.domain.utils.Failure
import com.mayokunadeniyi.domain.utils.HttpError
import com.mayokunadeniyi.domain.utils.Result
import com.mayokunadeniyi.domain.utils.Success
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Mayokun Adeniyi on 23/07/2020.
 */

abstract class BaseRepository<T : Any, R : DomainMapper<T>> : KoinComponent {
    private val connectivity: Connectivity by inject()
    private val contextProvider: CoroutineContextProvider by inject()

    /**
     * We Use this if we need to cache data after fetching it from the api, or retrieve something from cache
     */
    protected suspend fun fetchData(
        apiDataProvider: suspend () -> Result<T>,
        dbDataProvider: suspend () -> R
    ): Result<T> {
        return if (connectivity.hasNetworkAccess()) {
            withContext(contextProvider.io) {
                apiDataProvider()
            }
        } else {
            withContext(contextProvider.io) {
                val dbResult = dbDataProvider()
                if (dbResult != null) Success(dbResult.mapToDomainModel()) else Failure(
                    HttpError(
                        Throwable(DB_ENTRY_ERROR)
                    )
                )
            }
        }
    }

    /**
     * We use this when communicating only with the api service
     */
    protected suspend fun fetchData(dataProvider: () -> Result<T>): Result<T> {
        return if (connectivity.hasNetworkAccess()) {
            withContext(contextProvider.io) {
                dataProvider()
            }
        } else {
            Failure(HttpError(Throwable(GENERAL_NETWORK_ERROR)))
        }
    }
}
