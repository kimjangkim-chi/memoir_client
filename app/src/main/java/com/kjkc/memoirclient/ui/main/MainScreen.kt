package com.kjkc.memoirclient.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


    @Composable
fun MainScreen(){
    Box(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .background(
                color = Color.Red
            )
    )

}
