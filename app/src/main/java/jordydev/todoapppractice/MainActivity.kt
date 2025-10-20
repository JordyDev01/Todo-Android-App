package jordydev.todoapppractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import jordydev.todoapppractice.data.local.db.TodoDatabase
import jordydev.todoapppractice.ui.theme.TodoAppPracticeTheme
import jordydev.todoapppractice.view.MainScreen.MainScreen
import jordydev.todoapppractice.view.MainScreenVM
import jordydev.todoapppractice.view.components.CustomFAB

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainScreenVM by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoAppPracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        innerPadding,
                        viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodoAppPracticeTheme {
        Greeting("Android")
    }
}