package com.bignerdranch.android.criminalintent

import java.util.*

data class Crime(
    val id: UUID,
    var title: String = "",
    var date: Date = Date(),
    var isSolved: Boolean = false,
    var requiresPolice: Boolean = false
)