package com.kjkc.memoirclient.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.kjkc.memoirclient.ui.theme.MemoirClientTheme

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
            .background(Color.Black.copy(alpha = 0.3f)) // kjkc 컴포넌트로 변경 필요
    ) {
        Column(
            modifier = modifier
                .size(popupWidth, popupHeight)
                .background(Color.White, shape = RoundedCornerShape(16.dp)) // kjkc 컴포넌트로 변경 필요
                .padding(16.dp)
        ) {
            Text(
                text = "Select a Color",
                style = TextStyle(fontSize = 18.sp), // kjkc 컴포넌트로 변경 필요
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

@Composable
fun TwoButtonPopUp(
    modifier: Modifier = Modifier,
    content: String,
    onConfirm: (Boolean) -> Unit
) {
    // 현재 화면의 크기 가져오기
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    // 팝업의 크기 설정
    val popupWidth = screenWidth * 0.7f
    val popupHeight = screenHeight * 0.5f

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.3f)) // 불투명도만 높임 // kjkc 컴포넌트로 변경 필요
    ) {
        Column(
            modifier = modifier
                .size(popupWidth, popupHeight)
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Text(
                text = content,
                style = TextStyle(fontSize = 18.sp), // kjkc 컴포넌트로 변경 필요
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )

            // 확인 및 취소 버튼
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { onConfirm(true) },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.weight(1f).padding(end = 8.dp)
                ) {
                    Text(text = "확인")
                }
                Button(
                    onClick = { onConfirm(false) },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.weight(1f).padding(start = 8.dp)
                ) {
                    Text(text = "취소")
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchDropdownPopUp() {

    var textState by rememberSaveable { mutableStateOf("apple") } //위 값에 데이터 넣어 테스트하면 검색 됨
    val items = listOf("banana", "applepie", "pineapple")

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OneLineTextField(
            content = textState,
            onTextChanged = { textState = it }
        )
        FilteredList(
            items = items,
            filter = textState
        )
    }
}

@Composable
fun OneLineTextField(
    modifier: Modifier = Modifier,
    content: String = "",
    onTextChanged: (String) -> Unit
) {
    Surface(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = content,
            onValueChange = { onTextChanged(it) },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp,),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            textStyle = TextStyle(
                fontSize = 20.sp,
                color = Color.Black
            )
        )
    }
}

@Composable
fun FilteredList(
    items: List<String>,
    filter: String
) {
    val filteredItems = items.filter { it.contains(filter, ignoreCase = true) }

    Column {
        filteredItems.forEach { item ->
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.LightGray)
            ) {
                Text(
                    text = item,
                    modifier = Modifier
                        .padding(14.dp)
                        .fillMaxWidth(),
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MemoirPreviewOneButtonPopUp() {
    MemoirClientTheme {

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


@Preview(showBackground = true)
@Composable
fun MemoirPreviewTwoButtonPopUp() {
    MemoirClientTheme {
        // 예시로 팝업을 보여줌
        var showPopup by remember { mutableStateOf(true) }
        var result by remember { mutableStateOf<Boolean?>(null) }

        if (showPopup) {
            TwoButtonPopUp(
                content = "팝업 내용 입니다.",
                onConfirm = { confirmed ->
                    result = confirmed
                    showPopup = false
                }
            )
        }

        // 결과 표시
//                result?.let {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .background(if (it) Color.Green else Color.Red),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(text = if (it) "Confirmed" else "Cancelled", color = Color.White)
//                    }
//                }

    }
}

@Preview(showBackground = true)
@Composable
fun MemoirPreviewSearchDropdownPopUp() {
    MemoirClientTheme {
        SearchDropdownPopUp()
    }
}
