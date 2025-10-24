package jordydev.todoapppractice.view.navigation3

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import jordydev.todoapppractice.view.MainScreen.MainScreen
import jordydev.todoapppractice.view.MainScreen.MainScreenVM
import jordydev.todoapppractice.view.addTodoScreen.AddTodoScreen
import jordydev.todoapppractice.view.components.CustomFAB
import androidx.hilt.navigation.compose.hiltViewModel

data object ListTodo

 data object AddTodo


 @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
 @Composable
 fun NavTodo(
     viewModel: MainScreenVM = hiltViewModel()
 ) {
     val backStack = remember { mutableStateListOf<Any>(ListTodo) }

     Scaffold(modifier = Modifier.fillMaxSize(),
         floatingActionButton = {
             if (backStack.lastOrNull() == ListTodo) {
                 CustomFAB(
                     onClick = {
                         backStack.add(
                             AddTodo
                         )
                     }
                 )
             }

         }) { innerPadding ->
         NavDisplay(
             modifier = Modifier
                 .padding(
                     innerPadding
                 ),
             backStack = backStack,
             onBack = { backStack.removeLastOrNull() },
             entryProvider = { key ->
                 when (key) {
                     is ListTodo -> NavEntry(key) {
                         MainScreen(viewModel)
                     }

                     is AddTodo -> NavEntry(key) {
                         AddTodoScreen()
                     }

                     else -> NavEntry(Unit) { Text("Unknown route") }

                 }

             }
         )
     }
 }

