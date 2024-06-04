package com.kjkc.memoirclient

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FolderOpen
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class KjkcApp {

}

@Preview
@Composable
fun MainScreen() {
    Column {
        TopBar()
        Spacer(modifier = Modifier.height(16.dp))
        CategoryList()
        Spacer(modifier = Modifier.height(16.dp))
        RemindButton()
        // Add your main screen content here
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Left icon
        Icon(
            imageVector = Icons.Default.FolderOpen,
            contentDescription = "Home",
            tint = Color.White,
            modifier = Modifier.padding(end = 8.dp)
        )

        // Title
        Text(
            text = "Reminder",
            modifier = Modifier.weight(1f),
            color = Color.White,
            fontSize = 20.sp
        )

        // Right icons
        Row {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.padding(start = 8.dp)
            )
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                tint = Color.White,
                modifier = Modifier.padding(start = 8.dp)
            )
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings",
                tint = Color.White,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}


@Composable
fun CategoryList() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.surface)
            .shadow(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "카테고리1",
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onSurface)

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "카테고리2",
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun RemindButton() {
    Button(
        onClick = { /* Do something */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.primary)
            .height(56.dp), // Increase button height
    ) {
        Text(text = "Let's Remind", fontSize = 20.sp, color = Color.White)
    }
}
