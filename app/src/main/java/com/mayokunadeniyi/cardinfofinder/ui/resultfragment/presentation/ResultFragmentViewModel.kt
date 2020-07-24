package com.mayokunadeniyi.cardinfofinder.ui.resultfragment.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mayokunadeniyi.cardinfofinder.utils.asLiveData
import com.mayokunadeniyi.domain.models.CardInfo
import com.mayokunadeniyi.domain.usecases.GetCardInfoUseCase
import com.mayokunadeniyi.domain.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by Mayokun Adeniyi on 24/07/2020.
 */

class ResultFragmentViewModel(private val getCardInfoUseCase: GetCardInfoUseCase) : ViewModel() {
    private val _cardInfo = MutableLiveData<CardInfo>()
    val cardInfo = _cardInfo.asLiveData()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading.asLiveData()

    private val _dataFetchState = MutableLiveData<Boolean>()
    val dataFetchState = _dataFetchState.asLiveData()


    fun getRemoteCardInfo(cardNumber: Int) {
        _isLoading.postValue(true)
        viewModelScope.launch {
            when (val result =
                withContext(Dispatchers.IO) { getCardInfoUseCase(cardNumber, true) }) {
                is Result.Success -> {
                    _isLoading.postValue(false)
                    if (result.data != null) {
                        _dataFetchState.postValue(true)
                        _cardInfo.postValue(result.data)
                    } else {
                        _dataFetchState.postValue(false)
                    }
                }

                is Result.Error -> {
                    _isLoading.postValue(false)
                    _dataFetchState.postValue(false)
                }
            }
        }
    }

    fun getLocalCardInfo(cardNumber: Int) {
        _isLoading.postValue(true)
        viewModelScope.launch {
            when (val result =
                withContext(Dispatchers.IO) { getCardInfoUseCase(cardNumber, false) }) {
                is Result.Success -> {
                    _isLoading.postValue(false)
                    if (result.data != null) {
                        _dataFetchState.postValue(true)
                        _cardInfo.postValue(result.data)
                    } else {
                        getRemoteCardInfo(cardNumber)
                    }
                }
            }
        }
    }
}