package com.kjkc.memoirclient

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.kjkc.memoirclient.ui.main.MainScreen
import com.kjkc.memoirclient.ui.category.CategoryScreen
import com.kjkc.memoirclient.ui.remind.RemindScreen


interface MemoirDestination {
    val icon: ImageVector
    val route: String
    val screen: @Composable () -> Unit
}

/**
 * Memoir app navigation destinations
 */
object Main : MemoirDestination {
    override val icon = Icons.Filled.Search
    override val route = "Main"
    override val screen: @Composable () -> Unit = { MainScreen() }
}

object Category : MemoirDestination {
    override val icon = Icons.Filled.Add
    override val route = "Category"
    override val screen: @Composable () -> Unit = { CategoryScreen() }
}

object Remind : MemoirDestination {
    override val icon = Icons.Filled.Face
    override val route = "Remind"
    override val screen: @Composable () -> Unit = { RemindScreen() }
}


// Screens to be displayed in the top RallyTabRow
val memoirTabRowScreens = listOf(Main, Category, Remind)
