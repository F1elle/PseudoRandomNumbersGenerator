package com.f1elle.prng.prng.ui

sealed class PRNGEvent {
    data class EnteredFromValue(val value: String): PRNGEvent()
    data class EnteredToValue(val value: String): PRNGEvent()
    data class EnteredNumberOfValues(val value: String): PRNGEvent()
    data class EnteredSeparator(val value: String): PRNGEvent()
    object Generate: PRNGEvent()
    object Clear: PRNGEvent()
    object allowRepsClicked: PRNGEvent()
}