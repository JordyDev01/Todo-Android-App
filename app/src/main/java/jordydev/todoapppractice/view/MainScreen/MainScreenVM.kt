package jordydev.todoapppractice.view.MainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jordydev.todoapppractice.model.Todo
import jordydev.todoapppractice.repository.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenVM @Inject constructor(
    private val todoRepository: TodoRepository
): ViewModel() {
    val _listTodo: MutableStateFlow<List<Todo>> = MutableStateFlow(emptyList())
    val listTodo: StateFlow<List<Todo>> = _listTodo


    init {
        getTodos()
    }

     fun getTodos() {
        viewModelScope.launch {
            todoRepository.getTodos().collect {
                _listTodo.value = it
            }
        }
    }

    fun setDone(todo: Todo, isDone: Boolean) {
        viewModelScope.launch {
            todoRepository.updateTodo(todo.copy(isDone = isDone))
        }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch {
            todoRepository.deleteTodo(todo)
        }
    }

    fun insertTodo(todo: Todo) {
        viewModelScope.launch {
            todoRepository.insertTodo(todo)
        }
    }

}