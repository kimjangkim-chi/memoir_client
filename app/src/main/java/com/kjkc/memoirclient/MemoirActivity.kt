package com.kjkc.memoirclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kjkc.memoirclient.ui.theme.MemoirClientTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Button

import androidx.compose.material3.Scaffold

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kjkc.memoirclient.ui.component.MemoirTabRow


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemoirClientTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MemoirApp()
                }
            }
        }
    }
}

@Composable
fun MemoirApp() {

    var currentScreen: MemoirDestination by remember { mutableStateOf(Main) }
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier,
        topBar = {
            MemoirTabRow(
                allScreens = memoirTabRowScreens,
                onTabSelected = { newScreen -> navController.navigate(newScreen.route) },
                currentScreen = currentScreen
            )
        },
        bottomBar = {
            bottomAppButton()
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Main.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Main.route) {
                Main.screen()
            }
            composable(route = Category.route) {
                Category.screen()
            }
            composable(route = Remind.route) {
                Remind.screen()
            }
        }

    }

}

@Composable
fun bottomAppButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(10.dp)
    ) {
        Button(
            onClick = { /* 클릭 이벤트 처리 */ },
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Text("Let's Remind")
        }
    }
}


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun topAppBar(modifier: Modifier = Modifier) {
//
//    TopAppBar(
////        windowInsets = AppBarDefaults.topAppBarWindowInsets,
//        title = { Text("APP_NAME") },
//        navigationIcon = {
//            IconButton(onClick = { /* doSomething() */ }) {
//                Icon(Icons.Filled.Home, contentDescription = null)
//            }
//        },
//        actions = {
//            // RowScope here, so these icons will be placed horizontally
//            IconButton(onClick = { navController.navigate("search") }) {
//                Icon(Icons.Filled.Search, contentDescription = "search")
//            }
//            IconButton(onClick = { navController.navigate("add") }) {
//                Icon(Icons.Filled.Add, contentDescription = "add")
//            }
//            IconButton(onClick = { navController.navigate("settings") }) {
//                Icon(Icons.Filled.Settings, contentDescription = "settings")
//            }
//        }
//    )
//}

//@Composable
//fun ScreenContent(color: Color, label: String) {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(color),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(text = label, style = MaterialTheme.typography.bodyLarge, color = Color.Black)
//    }
//}

@Preview(showBackground = true)
@Composable
fun MemoirPreview() {
    MemoirClientTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MemoirApp()
        }
    }
}