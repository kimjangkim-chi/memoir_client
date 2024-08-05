package com.kjkc.memoirclient.ui.component.common.topbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.kjkc.memoirclient.ui.component.common.button.StandardIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    text: String,
    modifier: Modifier = Modifier,
    navigationButtonColor: Color,
    standardIconButtons: @Composable () -> Unit
) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = text,
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    standardIconButtons()
                }
            }
        },
        navigationIcon = {
            StandardIconButton(icon = Icons.Filled.Folder, color = navigationButtonColor, contentDescription = "folder")
        },
        modifier = modifier
    )
}

@Composable
@Preview
fun ButtonPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                TopBar(text = "APP_NAME", navigationButtonColor = Color.LightGray) {
                    StandardIconButton(icon = Icons.Default.Search, contentDescription = "search")
                    StandardIconButton(icon = Icons.Filled.Add, contentDescription = "add")
                    StandardIconButton(icon = Icons.Filled.Settings, contentDescription = "setting")
                }
            }
        ) {
            Text(text = "test", modifier = Modifier.padding(it))
        }

    }
}