package com.kjkc.memoirclient.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kjkc.memoirclient.MemoirApp
import com.kjkc.memoirclient.MemoirDestination
import com.kjkc.memoirclient.ui.theme.MemoirClientTheme


@Composable
fun OneLineTextField() {

    val textState = remember { mutableStateOf(TextFieldValue("")) }

    Surface(
        Modifier
            .height(56.dp)
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            label = { },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(6.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            textStyle = TextStyle(
                fontSize = 40.sp,
                color = Color.Black
            )
        )
    }
}

@Composable
fun MultiLineTextField() {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    val scrollState = rememberScrollState()

    Surface(
        Modifier
            .height(504.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .border(1.dp, Color.Gray,  RoundedCornerShape(6.dp))
                .background(Color.White)
                .padding(8.dp)
                .verticalScroll(scrollState)
        ) {
            BasicTextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                singleLine = false,
                textStyle = TextStyle(
                    fontSize = 40.sp,
                    color = Color.Black
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                )
            )
        }
    }
}

@Composable
fun OneLineTextFieldWithColorButton() {

    val textState = remember { mutableStateOf(TextFieldValue("")) }

    Surface(
        Modifier
            .height(56.dp)
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            label = { },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(6.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            textStyle = TextStyle(
                fontSize = 40.sp,
                color = Color.Black
            ),
            trailingIcon = {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .background(Color.Magenta, shape = RoundedCornerShape(6.dp))
                        .clickable { /* 버튼 클릭 시 동작 추가 */ }
                ) {
                    IconButton(
                        onClick = { /* 버튼 클릭 시 동작 추가 */ }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Trailing Icon",
                            tint = Color.White
                        )
                    }
                }
            }
        )
    }
}



@Preview(showBackground = true)
@Composable
fun MemoirPreview() {
    MemoirClientTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // 추가된 패딩으로 각 항목 사이에 여백을 줍니다.
        ) {
            OneLineTextField()
            MultiLineTextField()
            OneLineTextFieldWithColorButton()
        }

    }
}