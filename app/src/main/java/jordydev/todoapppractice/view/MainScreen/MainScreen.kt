package jordydev.todoapppractice.view.MainScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import jordydev.todoapppractice.model.Todo
import jordydev.todoapppractice.view.MainScreenVM
import jordydev.todoapppractice.view.components.CustomFAB
import jordydev.todoapppractice.view.components.TodoItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

@Composable
fun MainScreen(
    innerPaddingValues: PaddingValues,
    viewModel: MainScreenVM
) {
    val testTodoList = listOf(
        Todo(
            id = 0,
            title = "make breakfast",
            description = "wake up by 5 am to make it",
            isDone = true,
            createdAt = System.currentTimeMillis(),
            updatedAt = System.currentTimeMillis()
        ),
        Todo(
            id = 1,
            title = "make breakfast",
            description = "wake up by 5 am to make it",
            isDone = false,
            createdAt = System.currentTimeMillis(),
            updatedAt = System.currentTimeMillis()
        ),
        Todo(
            id = 2,
            title = "make breakfast",
            description = "wake up by 5 am to make it",
            isDone = false,
            createdAt = System.currentTimeMillis(),
            updatedAt = System.currentTimeMillis()
        )
    )

    val todoList = viewModel.listTodo.collectAsStateWithLifecycle(
        initialValue = emptyList(),
        minActiveState = Lifecycle.State.STARTED
    ).value

    var visible by remember { mutableStateOf(false) }
    val density = LocalDensity.current


    LaunchedEffect(Unit) {
        visible = true
    }
    Column(
        modifier = Modifier.padding(innerPaddingValues)
            .background(
                MaterialTheme.colorScheme.background
            )
    ) {
        AnimatedVisibility(
            visible,
            enter = slideInVertically {
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                // Expand from the top.
                expandFrom = Alignment.Top
            ) + fadeIn(
                // Fade in with the initial alpha of 0.3f.
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                itemsIndexed( testTodoList) { index, todo ->

                     TodoItem(
                         todo = todo ,
                         // function in TodoItem will return the !isDone value
                         isDone = { viewModel.setDone(todo, it) },
                         onDelete = { viewModel.deleteTodo(todo) },
                     )
                }
            }
        }
    }



}