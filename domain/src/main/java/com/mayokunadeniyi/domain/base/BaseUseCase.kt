package com.mayokunadeniyi.domain.base

import com.mayokunadeniyi.domain.utils.Result

/**
 * Created by Mayokun Adeniyi on 23/07/2020.
 */

interface BaseUseCase<T : Any, R : Any> {
    suspend operator fun invoke(param: T): Result<R>
}