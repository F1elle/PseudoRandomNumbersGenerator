package com.f1elle.prng.prng.ui.utils

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.f1elle.prng.theme.Accent
import com.f1elle.prng.theme.Disabled

@Composable
fun appButton(onButtonClick: () -> Unit,
              enabled: Boolean,
              buttonText: String) {
    Button(onClick = onButtonClick ,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Accent,
            contentColor = Color.White,
            disabledBackgroundColor = Disabled
        )) {
        Text(text = buttonText)
    }
}