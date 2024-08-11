package com.kjkc.memoirclient.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.kjkc.memoirclient.ui.theme.MemoirClientTheme

class PopUp {
    @Composable
    fun OneButtonPopUp(
        modifier: Modifier = Modifier,
        content: List<Color>,
        onConfirm: (Color?) -> Unit
    ) {
        // 현재 화면의 크기 가져오기
        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp.dp
        val screenHeight = configuration.screenHeightDp.dp

        // 팝업의 크기 설정
        val popupWidth = screenWidth * 0.7f
        val popupHeight = screenHeight * 0.5f

        var selectedColor by remember { mutableStateOf<Color?>(null) }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3f))
        ) {
            Column(
                modifier = modifier
                    .size(popupWidth, popupHeight)
                    .background(Color.White, shape = RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Text(
                    text = "Select a Color",
                    style = TextStyle(fontSize = 18.sp),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // 색상 리스트를 4x3 그리드로 표시
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    for (row in 0..2) {  // 세로로 3개의 행
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly, // 가로 간격을 동일하게 배분
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            for (column in 0..3) {  // 가로로 4개의 열
                                val index = row * 4 + column
                                if (index < content.size) {
                                    Box(
                                        modifier = Modifier
                                            .size(40.dp)
                                            .background(content[index], shape = RoundedCornerShape(8.dp))
                                            .border(
                                                width = 2.dp,
                                                color = if (selectedColor == content[index]) Color.Gray else Color.Transparent,
                                                shape = RoundedCornerShape(8.dp)
                                            )
                                            .clickable { selectedColor = content[index] }
                                    )
                                }
                            }
                        }
                    }
                }

                // 확인 버튼
                Button(
                    onClick = { onConfirm(selectedColor) }, // 선택된 색상을 반환
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 16.dp)
                ) {
                    Text(text = "확인")
                }
            }
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
                // 예시로 팝업을 보여줌
                var showPopup by remember { mutableStateOf(true) }
                var selectedColor by remember { mutableStateOf<Color?>(null) }

                if (showPopup) {
                    OneButtonPopUp(
                        content = listOf(
                            Color.Red, Color.Blue, Color.Green, Color.Yellow, Color.Cyan,
                            Color.Magenta, Color.Black, Color.Gray, Color.White, Color.LightGray,
                            Color.DarkGray, Color.Blue.copy(alpha = 0.5f)
                        ),
                        onConfirm = { color ->
                            selectedColor = color
                            showPopup = false
                        }
                    )
                }

                // 선택된 색상을 화면에 표시
//                selectedColor?.let {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .background(it),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(text = "Selected Color", color = Color.White)
//                    }
//                }

            }
        }
    }
}