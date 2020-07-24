package com.mayokunadeniyi.data.mapper

/**
 * Created by Mayokun Adeniyi on 24/07/2020.
 */



interface BaseMapperRepository<E, D> {

    fun transform(type: E): D

    fun transformToRepository(type: D): E

}