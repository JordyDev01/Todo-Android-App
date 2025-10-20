package jordydev.todoapppractice.repository

import jordydev.todoapppractice.model.Todo
import kotlinx.coroutines.flow.Flow


interface TodoRepository {
    suspend fun getTodos(): Flow<List<Todo>>
    suspend fun getTodoById(id: Int): Todo?
    suspend fun deleteTodo(todo: Todo)
    suspend fun insertTodo(todo: Todo)
    suspend fun updateTodo(todo: Todo)
}


