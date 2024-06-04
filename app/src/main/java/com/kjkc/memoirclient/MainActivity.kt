package com.kjkc.memoirclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kjkc.memoirclient.ui.theme.MemoirClientTheme

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
        }
    ) {
        LazyColumn(contentPadding = it) {
            items(3) {
                Text(text = "test")
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
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "APP_NAME",
                    style = MaterialTheme.typography.displayMedium
                )
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