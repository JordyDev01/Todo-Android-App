package jordydev.todoapppractice.repository

import jordydev.todoapppractice.data.local.dao.TodoDao
import jordydev.todoapppractice.model.Todo
import kotlinx.coroutines.flow.Flow


class TodoRepositoryImpl(
    private val todoDao: TodoDao
): TodoRepository {

    override suspend fun getTodos(): Flow<List<Todo>> = todoDao.getAllTodos()

    override suspend fun getTodoById(id: Int): Todo? = todoDao.getTodoById(id)

    override suspend fun deleteTodo(todo: Todo) = todoDao.deleteTodo(todo)

    override suspend fun insertTodo(todo: Todo) = todoDao.insertTodo(todo)


    override suspend fun updateTodo(todo: Todo) = todoDao.updateTodo(todo)


}