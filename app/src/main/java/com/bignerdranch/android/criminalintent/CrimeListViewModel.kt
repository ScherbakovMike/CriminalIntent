package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.criminalintent.database.CrimeRepository
import kotlinx.coroutines.launch

class CrimeListViewModel : ViewModel() {

    private val crimeRepository = CrimeRepository.get()

    val crimes = mutableListOf<Crime>()

    init {
        viewModelScope.launch {
            crimes += loadCrimes()
        }
    }

    suspend fun loadCrimes(): List<Crime> {
        return crimeRepository.getCrimes()
    }

}