package com.f1elle.prng.prng.ui.utils

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.f1elle.prng.theme.Border


@Composable
fun textField(title: String,
              textFieldValue: String,
              onValueChange: (String) -> Unit,
              keyboardOptions: KeyboardOptions){
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(end = 100.dp, start = 50.dp)){
        Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
        Spacer(Modifier.weight(1f))
        BasicTextField(value = textFieldValue,
            modifier = Modifier.border(width = 1.5.dp,
                shape = RoundedCornerShape(7.dp),
                brush = SolidColor(Border)).padding(5.dp),
            onValueChange = onValueChange,
            keyboardOptions = keyboardOptions,
            enabled = true,
            singleLine = true,
            textStyle = TextStyle(
                color = Color.White,
                fontSize = 16.sp),
            cursorBrush = SolidColor(Color.White),
            decorationBox = {
                    innerTextField ->
                Row{
                    Text(text=textFieldValue, color = Color.Transparent)

                }
                innerTextField()
            }
        )
    }

}