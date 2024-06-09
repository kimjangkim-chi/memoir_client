package com.kjkc.memoirclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kjkc.memoirclient.ui.theme.MemoirClientTheme
import kotlin.random.Random

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
                }
            }
        }
    }
}

@Composable
fun App() {
    Scaffold(
        topBar = {
            AppBar()
        },
        bottomBar = {
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Let's Remind", style = MaterialTheme.typography.displayLarge)

            }
        },
        containerColor = Color.Black
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            userScrollEnabled = true,
            contentPadding = PaddingValues(10.dp),
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    end = 10.dp,
                    top = it.calculateTopPadding() + 10.dp,
                    bottom = it.calculateBottomPadding() + 20.dp
                )
                .background(Color.LightGray, RoundedCornerShape(10.dp))
        ) {
            items(30) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Folder,
                        contentDescription = "folder",
                        modifier = Modifier.size(100.dp),
                        tint = Color(
                            Random.nextInt(256),
                            Random.nextInt(256),
                            Random.nextInt(256),
                            Random.nextInt(256)
                        )
                    )
                    Text(text = "카테고리")
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "APP_NAME",
                    style = MaterialTheme.typography.displaySmall
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search",
                        modifier = Modifier.size(30.dp)
                    )
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "add",
                        modifier = Modifier.size(30.dp)
                    )
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "setting",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(30.dp)) {
                Icon(
                    imageVector = Icons.Filled.Folder,
                    contentDescription = "folder",
                )

            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MemoirClientTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            App()
        }
    }
}