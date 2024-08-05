package com.kjkc.memoirclient.ui.component.common.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable()
fun StandardIconButton (
    icon: ImageVector,
    color: Color = Color.Black,
    contentDescription: String,
    onClick: () -> Unit = {}
) {
    IconButton(onClick = onClick, modifier = Modifier.size(30.dp)) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = color
        )

    }
}

@Composable()
fun FolderButton(
    text: String,
    color: Color,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.Folder,
                contentDescription = text,
                tint = color,
                modifier = Modifier.size(100.dp)
            )
            Text(text = text, color= Color.Black)
        }


    }
}

@Composable()
fun SmallButton(
    text: String,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(3.dp, Color.LightGray),
        colors = ButtonDefaults.buttonColors(Color(255, 255, 255), Color(0, 0, 0)),
        modifier = Modifier.size(100.dp, 50.dp)
    ) {
        Text(text = text)
    }
}

@Composable()
fun MediumButton(
    text: String,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(3.dp, Color.LightGray),
        colors = ButtonDefaults.buttonColors(Color(255, 255, 255), Color(0, 0, 0)),
        modifier = Modifier.size(200.dp, 50.dp)
    ) {
        Text(text = text)
    }
}

@Composable()
fun MaxButton(
    text: String,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(Color(255, 255, 255), Color(0, 0, 0)),
        modifier = Modifier
            .fillMaxWidth()
            .shadow(3.dp, RoundedCornerShape(5.dp))
            .height(100.dp)
    ) {
        Text(text = text)
    }
}

@Composable()
@Preview()
fun ButtonPreview() {
    val previewColor = Color.LightGray
    val previewText = "test"

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            StandardIconButton(icon = Icons.Filled.Folder, contentDescription = "folder")
            FolderButton(color = previewColor, text = previewText)
            SmallButton(previewText)
            MediumButton(previewText)
            MaxButton(previewText)
        }

    }
}