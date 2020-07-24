package com.mayokunadeniyi.cardinfofinder.di

import com.mayokunadeniyi.cardinfofinder.ui.resultfragment.presentation.ResultFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Mayokun Adeniyi on 24/07/2020.
 */

val presentationModule = module {
    viewModel { ResultFragmentViewModel(get()) }
}