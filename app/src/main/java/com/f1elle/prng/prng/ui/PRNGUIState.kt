package com.f1elle.prng.prng.ui


data class PRNGUIState(
    val from: String,
    val to: String,
    val number: String,
    val generatedNumbers: String,
    val separator: String,
    val allowReps: Boolean,
    val generateActive: Boolean,
    val copyActive: Boolean
)
