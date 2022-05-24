package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import kotlin.random.Random

class CrimeListViewModel : ViewModel() {


    val crimes = mutableListOf<Crime>()

    init {
        viewModelScope.launch {
            crimes+=loadCrimes()
        }
    }

    suspend fun loadCrimes():List<Crime> {
        val result = mutableListOf<Crime>()
        delay(1)
        for (i in 0 until 100) {
            val crime = Crime(
                id = UUID.randomUUID(),
                title = "Crime #$i",
                isSolved = i % 2 == 0,
                requiresPolice = Random.nextBoolean()
            )

            result.add(crime)
        }
        return result
    }

}