package by.killraider.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainLayout() {
    val navController = rememberNavController()
    val items = listOf(Screen.Home, Screen.Workout, Screen.Book, Screen.Stats)

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFF030712),
                contentColor = Color(0xFF3B82F6)
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                items.forEach {
                    screen -> val isSelected = currentRoute == screen.route

                    NavigationBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = if (isSelected) screen.activeIconId else screen.iconId),
                                contentDescription = screen.title
                            )
                        },
                        selected = isSelected,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF3B82F6),
                            unselectedIconColor = Color(0xFF4B5563),
                            indicatorColor = Color.Transparent
                        ),
                        onClick = {
                            if (currentRoute != screen.route) {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }

                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {MainScreen(Screen.Home)}
            composable(Screen.Workout.route) {MainScreen(Screen.Workout)}
            composable(Screen.Book.route) {MainScreen(Screen.Book)}
            composable(Screen.Stats.route) {MainScreen(Screen.Stats)}

        }
    }
}