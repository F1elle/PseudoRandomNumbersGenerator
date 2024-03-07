package com.f1elle.prng.prng.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.f1elle.prng.R
import com.f1elle.prng.prng.ui.utils.Screen
import com.f1elle.prng.prng.ui.utils.appButton
import com.f1elle.prng.prng.ui.utils.textField
import com.f1elle.prng.theme.Accent
import com.f1elle.prng.theme.Background
import com.f1elle.prng.theme.Border


@Composable
fun prngScreen(navController: NavController) {

    val viewModel = viewModel<PRNGViewModel>()
    val clipboardManager: ClipboardManager = LocalClipboardManager.current


    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(color = Background),
               contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp),
               verticalArrangement = Arrangement.spacedBy(8.dp)){
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Spacer(modifier = Modifier.weight(1f))
                Text(text = stringResource(id = R.string.title), style = TextStyle(color = Color.White,
                                                                                    fontSize = 18.sp))
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "©",
                    style = TextStyle(color = Color.White,
                                        fontSize = 20.sp),
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.CoprScreen.route) })
            }
        }
        item {Spacer(Modifier.height(10.dp))}
        item {
            textField(
                title = stringResource(id = R.string.from),
                textFieldValue = viewModel.uiState.from,
                onValueChange = {viewModel.onEvent(PRNGEvent.EnteredFromValue(it))},
                KeyboardOptions(keyboardType = KeyboardType.Number))
        }
        item {
            textField(
                title = stringResource(id = R.string.to),
                textFieldValue = viewModel.uiState.to,
                onValueChange = {viewModel.onEvent(PRNGEvent.EnteredToValue(it))},
                KeyboardOptions(keyboardType = KeyboardType.Number))
        }
        item {
            textField(
                title = stringResource(id = R.string.number),
                textFieldValue = viewModel.uiState.number,
                onValueChange = {viewModel.onEvent(PRNGEvent.EnteredNumberOfValues(it))},
                KeyboardOptions(keyboardType = KeyboardType.Number))
        }
        item {
            textField(
                title = stringResource(id = R.string.separator),
                textFieldValue = viewModel.uiState.separator,
                onValueChange = {viewModel.onEvent(PRNGEvent.EnteredSeparator(it))},
                KeyboardOptions(keyboardType = KeyboardType.Text))
        }
        item {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(end = 100.dp, start = 50.dp)) {
                Text(text = stringResource(id = R.string.allow_reps),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp))
                Checkbox(checked = viewModel.uiState.allowReps,
                    onCheckedChange = {viewModel.onEvent(PRNGEvent.allowRepsClicked)},
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = Border,
                        checkedColor = Accent,
                        checkmarkColor = Color.White,

                    ))
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        item {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                appButton(onButtonClick = { viewModel.onEvent(PRNGEvent.Generate) }, 
                    enabled = viewModel.uiState.generateActive, 
                    buttonText = stringResource(id = R.string.generate))
                Spacer(Modifier.width(10.dp))
                appButton(onButtonClick = { viewModel.onEvent(PRNGEvent.Clear) },
                    enabled = true,
                    buttonText = stringResource(id = R.string.clear))
                Spacer(Modifier.width(10.dp))
                appButton(onButtonClick = { clipboardManager.setText(AnnotatedString(viewModel.uiState.generatedNumbers)) },
                    enabled = viewModel.uiState.copyActive,
                    buttonText = stringResource(id = R.string.copy))
            }
        }
        item {
            BasicTextField(value = viewModel.uiState.generatedNumbers,
                modifier = Modifier
                    .border(
                        width = 1.5.dp,
                        shape = RoundedCornerShape(7.dp),
                        brush = SolidColor(Border)
                    )
                    .padding(5.dp)
                    .fillMaxSize(),
                onValueChange = { /* TODO */ },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                enabled = true,
                readOnly = true,
                singleLine = false,
                maxLines = 15,
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp),
                cursorBrush = SolidColor(Color.White),
                decorationBox = {
                        innerTextField ->
                    Row{
                        Text(text="", color = Color.Transparent)

                    }
                    innerTextField()
                }
            )
        }

    }

}