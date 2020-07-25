package com.mayokunadeniyi.cardinfofinder.ui.resultfragment.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mayokunadeniyi.domain.models.CardInfo
import com.mayokunadeniyi.domain.usecases.GetCardInfoUseCase
import com.mayokunadeniyi.domain.utils.Result
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import org.mockito.ArgumentCaptor.*
import org.junit.Assert.*
import org.hamcrest.CoreMatchers.*
import org.junit.Rule
import org.mockito.ArgumentMatchers.*
import org.mockito.Mockito.*
import java.lang.Exception

/**
 * Created by Mayokun Adeniyi on 24/07/2020.
 */
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ResultFragmentViewModelTest {

    //region constants

    //endregion constants

    //region helper fields
    @Mock
    private lateinit var getCardInfoUseCase: GetCardInfoUseCase
    //endregion helper fields

    private lateinit var systemUnderTest: ResultFragmentViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setUp() {
        systemUnderTest = ResultFragmentViewModel(getCardInfoUseCase)

    }


    @Test
    fun getCardInfoRemote_nullDataReturned_dataFetchState() = mainCoroutineRule.runBlockingTest {

        `when`(getCardInfoUseCase(CARD_NUMBER,true)).thenReturn(Result.Success(null))

        mainCoroutineRule.pauseDispatcher()
        systemUnderTest.getRemoteCardInfo(CARD_NUMBER)

        mainCoroutineRule.resumeDispatcher()

        assertThat(systemUnderTest.dataFetchState.getOrAwaitValue(), `is`(false))
    }

    @Test
    fun getCardInfoRemote_errorReturned_dataFetchState() = mainCoroutineRule.runBlockingTest {

        `when`(getCardInfoUseCase(CARD_NUMBER,true)).thenReturn(Result.Error(Exception("Invalid")))

        mainCoroutineRule.pauseDispatcher()
        systemUnderTest.getRemoteCardInfo(CARD_NUMBER)

        mainCoroutineRule.resumeDispatcher()

        assertThat(systemUnderTest.dataFetchState.getOrAwaitValue(), `is`(false))
    }

    @Test
    fun getCardInfoRemote_successDataReturned_dataFetchState() = mainCoroutineRule.runBlockingTest {

        `when`(getCardInfoUseCase(CARD_NUMBER,true)).thenReturn(Result.Success(cardInfo))

        mainCoroutineRule.pauseDispatcher()
        systemUnderTest.getRemoteCardInfo(CARD_NUMBER)

        mainCoroutineRule.resumeDispatcher()

        assertThat(systemUnderTest.dataFetchState.getOrAwaitValue(), `is`(true))
    }

    @Test
    fun getCardInfoRemote_successCardInfoReturned_checkCardInfoValue() =  mainCoroutineRule.runBlockingTest{
        `when`(getCardInfoUseCase(CARD_NUMBER,true)).thenReturn(Result.Success(cardInfo))
        mainCoroutineRule.pauseDispatcher()

        systemUnderTest.getRemoteCardInfo(CARD_NUMBER)

        mainCoroutineRule.resumeDispatcher()

        assertThat(systemUnderTest.cardInfo.getOrAwaitValue(), `is`(cardInfo))
    }




    // region helper methods

    // endregion helper methods

    // region helper classes

    // endregion helper classes

}