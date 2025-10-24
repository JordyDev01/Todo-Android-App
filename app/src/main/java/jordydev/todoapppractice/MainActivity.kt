package jordydev.todoapppractice

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import jordydev.todoapppractice.ui.theme.TodoAppPracticeTheme
import jordydev.todoapppractice.view.MainScreen.MainScreenVM
import jordydev.todoapppractice.view.components.CustomFAB
import jordydev.todoapppractice.view.navigation3.NavTodo

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoAppPracticeTheme {

                    NavTodo()

            }
        }
    }
}