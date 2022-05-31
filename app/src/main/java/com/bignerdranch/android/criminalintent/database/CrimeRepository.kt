package com.bignerdranch.android.criminalintent.database

import android.content.Context
import androidx.room.Room
import com.bignerdranch.android.criminalintent.Crime
import java.util.*

private const val DATABASE_NAME = "crime-database"

class CrimeRepository private constructor(context: Context) {

    private val database: CrimeDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            CrimeDatabase::class.java,
            DATABASE_NAME
        )
        .createFromAsset(DATABASE_NAME)
        //.fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()

    suspend fun getCrimes(): List<Crime> =
        database.crimeDao().getCrimes()

    suspend fun getCrime(id: UUID): Crime? =
        database.crimeDao().getCrime(id)

    companion object {
        private var INSTANCE: CrimeRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }

        fun get(): CrimeRepository {
            return INSTANCE ?:
            throw IllegalStateException("CrimeRepository must be initialized")
        }

    }
}