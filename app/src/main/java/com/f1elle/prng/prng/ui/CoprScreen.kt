package com.f1elle.prng.prng.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.f1elle.prng.R
import com.f1elle.prng.theme.Background

@Composable
fun coprScreen(navController: NavController) {
    val uriHandler = LocalUriHandler.current
    val git = "https://github.com/F1elle/PseudoRandomNumbersGenerator"
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(color = Background),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        item {
            Text(stringResource(id = R.string.prng), style = TextStyle(color = Color.White, fontSize = 18.sp))
        }
        item {
            Text(stringResource(id = R.string.byname), style = TextStyle(color = Color.White, fontSize = 18.sp))
        }
        item {
            Text(stringResource(id = R.string.group), style = TextStyle(color = Color.White, fontSize = 18.sp))
        }
        item {
            Text(stringResource(id = R.string.year), style = TextStyle(color = Color.White, fontSize = 18.sp))
        }
        item {
            Icon(painter = painterResource(id = R.drawable.git),
                contentDescription = "GitHub repo",
                tint = Color.White,
                modifier = Modifier
                    .size(30.dp)
                    .clickable { uriHandler.openUri(git) })
        }
    }
}