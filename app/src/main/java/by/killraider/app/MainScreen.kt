package by.killraider.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(screen: Screen) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(screen.backgroundColor))
}