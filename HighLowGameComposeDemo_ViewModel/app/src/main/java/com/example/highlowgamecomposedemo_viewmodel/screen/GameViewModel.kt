package com.example.highlowgamecomposedemo_viewmodel.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.Random

class GameViewModel : ViewModel() {

    var generatedNum by mutableStateOf(0)
    var upperBound by mutableStateOf(3)
    var counter by mutableStateOf(0)

    init {
        /*
        savedStateHandle.get<Int>("upperBound")?.let {
            upperBound = it
        }
         */

        generateNewNum()
    }

    fun generateNewNum() {
        generatedNum = Random(System.currentTimeMillis()).nextInt(upperBound)
        counter = 0
    }

    fun increaseCounter() {
        counter++
    }
}