package com.f1elle.prng.prng.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.f1elle.prng.prng.data.generate
import com.f1elle.prng.prng.data.generateWithReps

class PRNGViewModel: ViewModel() {

    var uiState by mutableStateOf(
        PRNGUIState(
            from = "1",
            to = "100",
            number = "10",
            generatedNumbers = "",
            separator = ", ",
            allowReps = false,
            generateActive = true,
            copyActive = false
    )
    )
        private set


    fun onEvent(event: PRNGEvent){
        when(event){
            is PRNGEvent.EnteredFromValue -> {
                if (event.value == ""){
                    uiState = uiState.copy(
                        from = event.value
                    )
                }else if (event.value[0] != '-' && event.value.contains("-") || event.value.count{it == '-'} > 1){
                    /*TODO*/
                }else if (!event.value.contains(" ") && !event.value.contains(",") && !event.value.contains(".")){
                    uiState = uiState.copy(
                        from = event.value
                    )
                }
                checkGenerateAvailability()

            }
            is PRNGEvent.EnteredToValue -> {
                if (event.value == ""){
                    uiState = uiState.copy(
                        to = event.value
                    )
                }else if (event.value[0] != '-' && event.value.contains("-") || event.value.count{it == '-'} > 1){
                    /*TODO*/
                }else if (!event.value.contains(" ") && !event.value.contains(",") && !event.value.contains(".")){
                    uiState = uiState.copy(
                        to = event.value
                    )
                }
                checkGenerateAvailability()
            }
            is PRNGEvent.EnteredNumberOfValues -> {
                if (event.value == ""){
                    uiState = uiState.copy(
                        number = event.value
                    )
                }else if (!event.value.contains(" ") && !event.value.contains(",") && !event.value.contains(".") && !event.value.contains("-")){
                    uiState = uiState.copy(
                        number = event.value
                    )
                }
                checkGenerateAvailability()
            }
            is PRNGEvent.EnteredSeparator -> {
                uiState = uiState.copy(
                    separator = event.value
                )
            }
            is PRNGEvent.Generate ->{
                uiState = uiState.copy(
                    copyActive = true,
                    generatedNumbers = if (uiState.allowReps){
                        generateWithReps(uiState.from.toInt(), uiState.to.toInt(), uiState.number.toInt(), uiState.separator)
                    }else {
                        generate(
                            uiState.from.toInt(),
                            uiState.to.toInt(),
                            uiState.number.toInt(),
                            uiState.separator
                        )
                    }
                )
            }
            is PRNGEvent.Clear -> {
                uiState = uiState.copy(
                    copyActive = false,
                    generatedNumbers = ""
                )
            }
            is PRNGEvent.allowRepsClicked -> {
                uiState = uiState.copy(
                    allowReps = !uiState.allowReps
                )
                checkGenerateAvailability()
            }
        }
    }
    private fun checkGenerateAvailability() {
        when {
            uiState.to == "" || uiState.from == "" || uiState.number == "" -> {
                uiState = uiState.copy(
                    generateActive = false
                )
            }
            uiState.to == "-" || uiState.from == "-" || uiState.number == "-" -> {
                uiState = uiState.copy(
                    generateActive = false
                )
            }
            uiState.number.toInt() > 10000 -> {
                uiState = uiState.copy(
                    generateActive = false
                )
            }
            uiState.to.toInt() < uiState.from.toInt() -> {
                uiState = uiState.copy(
                    generateActive = false
                )
            }
            uiState.to.toInt() - uiState.from.toInt() < uiState.number.toInt() && !uiState.allowReps -> {
                uiState = uiState.copy(
                    generateActive = false
                )
            }
            else -> {
                uiState = uiState.copy(
                    generateActive = true
                )
            }
        }

    }
}