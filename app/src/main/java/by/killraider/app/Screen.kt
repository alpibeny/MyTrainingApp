package by.killraider.app

import androidx.compose.ui.graphics.Color

sealed class Screen ( val route: String,
                      val title: String,
                      val iconId: Int,
                      val activeIconId: Int,
                      val backgroundColor: Color) {

    object Home : Screen(
        route = "home",
        title = "Главная",
        iconId = R.drawable.menu_home,
        activeIconId = R.drawable.menu_home_active,
        backgroundColor = Color(0xFF0F172A)
    )

    object Workout : Screen(
        route = "workout",
        title = "Тренировки",
        iconId = R.drawable.menu_train,
        activeIconId = R.drawable.menu_train_active,
        backgroundColor = Color(0xFF1E1B4B)
    )

    object Book : Screen (
        route = "book",
        title = "Книги",
        iconId = R.drawable.menu_book,
        activeIconId = R.drawable.menu_book_active,
        backgroundColor = Color(0xFF064E3B)
    )

    object Stats : Screen(
        route = "stats",
        title = "Статистика",
        iconId = R.drawable.menu_rank,
        activeIconId = R.drawable.menu_rank_active,
        backgroundColor = Color(0xFF581C87)
    )


}