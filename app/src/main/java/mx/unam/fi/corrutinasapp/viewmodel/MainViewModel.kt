package mx.unam.fi.corrutinasapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainViewModel: ViewModel(){
    var resultState by mutableStateOf(false)
        private set

    var resultState2 by mutableStateOf(false)
        private set

    var countTime by mutableIntStateOf(0)
        private set

    var countTime2 by mutableIntStateOf(0)
        private set


    private var oneCount by mutableStateOf(false)

    private var job: Job? = null


    fun fetchData(){
        job = viewModelScope.launch {
            for (i in 1..5){
                delay(1000)
                countTime = i
            }
            if(countTime == 5){
                resultState = true
                for (i in 1..5){
                    delay(1000)
                    countTime2 = i
                }
            }
            if(countTime2 == 5){
                resultState2 = true
            }
            oneCount = true
        }

        if(oneCount){
            job?.cancel()
        }
    }

    fun reset() {
        countTime = 0
        countTime2 = 0
        oneCount = false
        resultState = false
        resultState2 = false
        job?.cancel()
    }
}