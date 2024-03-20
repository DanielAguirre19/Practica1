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


    var countTime by mutableIntStateOf(0)
        private set



    private var oneCount by mutableStateOf(false)

    private var job: Job? = null


    fun fetchData(){
        job = viewModelScope.launch {
            for (i in 1..5){
                delay(1000)
                countTime = i
            }
            oneCount = true
        }

        if(oneCount){
            job?.cancel()
        }
    }

}