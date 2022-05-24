package com.bignerdranch.android.criminalintent.database

import androidx.room.Dao
import androidx.room.Query
import com.bignerdranch.android.criminalintent.Crime
import java.util.*

@Dao
interface CrimeDao {
    @Query("SELECT * FROM Crime")
    fun getCrimes(): List<Crime>

    @Query("SELECT * FROM crime WHERE id=(:id)")
    fun getCrime(id: UUID): Crime?
}