package com.kjkc.memoirclient.ui.component.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kjkc.memoirclient.ui.theme.KJKCColors
import com.kjkc.memoirclient.ui.theme.KJKCText


/*
 * 5-1. fun ListIconTitleDateWithoutBackground(modifier, title, date, iconTint)
 *      fun ListIconTitleDateWitBackground(modifier, title, date, iconTint)
 * 아이콘 모양은 고정
 *
 * 5-2. fun ListTitleWithContent(modifier, title, content)
 * 5-3. fun ListDoubleTitleWithContent(modifier, title1, title2, content)
 * 5-4. fun ListTContent(content)
 */
@Composable
@Preview
fun ListIconTitleDateWithoutBackground(
    modifier: Modifier = Modifier,
    title: String = "Tilte",
    date: String = "2000.00.00",
    iconTint: Color = KJKCColors.Grey300 // Use your predefined color
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp) // Adjust padding as needed
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon on the left
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Circle Icon",
                tint = iconTint,
                modifier = Modifier.size(24.dp) // Adjust icon size as needed
            )

            Spacer(modifier = Modifier.width(16.dp)) // Space between icon and text

            // Large text in the center
            Text(
                text = title,
                style = KJKCText.black_24_normal,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f) // Take up remaining space
            )

            // Text on the right
            Text(
                text = date,
                style = KJKCText.grey_16_normal,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun ListIconTitleDateWitBackground(
    modifier: Modifier = Modifier,
    title: String = "Tilte",
    date: String = "2000.00.00",
    iconTint: Color = KJKCColors.Grey300, // Use your predefined color
    backgroundColor: Color = KJKCColors.Grey100, // Background color
    shape: Shape = RoundedCornerShape(50.dp), // Rounded rectangle shape
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = backgroundColor, shape = shape)
            .padding(16.dp) // Adjust padding as needed
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon on the left
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Circle Icon",
                tint = iconTint,
                modifier = Modifier.size(24.dp) // Adjust icon size as needed
            )

            Spacer(modifier = Modifier.width(16.dp)) // Space between icon and text

            // Large text in the center
            Text(
                text = title,
                style = KJKCText.black_24_normal,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f) // Take up remaining space
            )

            // Text on the right
            Text(
                text = date,
                style = KJKCText.grey_16_normal,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun ListTitleWithContent(
    modifier: Modifier = Modifier,
    title: String = "Title",
    subTitle: String = "content"
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp) // Adjust padding as needed
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = title,
                    style = KJKCText.black_24_normal,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = subTitle,
                    style = KJKCText.grey_12_normal,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.width(100.dp)) // Empty space on the right
        }
    }
}

@Preview
@Composable
fun ListDoubleTitleWithContent(
    modifier: Modifier = Modifier,
    title1: String = "Title1",
    title2: String = "Title2",
    subTitle: String = "content"
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp) // Adjust padding as needed
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Row{
                    Text(
                        text = title1,
                        style = KJKCText.black_24_normal,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.width(16.dp)) // Space between icon and text
                    Text(
                        text = title2,
                        style = KJKCText.black_24_normal,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = subTitle,
                    style = KJKCText.grey_12_normal,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.width(100.dp)) // Empty space on the right
        }
    }
}

@Preview
@Composable
fun ListContent(
    modifier: Modifier = Modifier,
    content: String = "content"
) {
    Box(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp) // Adjust padding as needed
    ) {
        Text(
            text = content,
            style = KJKCText.black_16_normal
        )
    }
}
