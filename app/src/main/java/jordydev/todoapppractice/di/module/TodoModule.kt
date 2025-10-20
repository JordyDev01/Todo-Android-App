package jordydev.todoapppractice.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jordydev.todoapppractice.data.local.dao.TodoDao
import jordydev.todoapppractice.data.local.db.TodoDatabase
import jordydev.todoapppractice.repository.TodoRepository
import jordydev.todoapppractice.repository.TodoRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TodoModule {

    @Provides
    @Singleton
    fun provideTodoDB(@ApplicationContext context: Context): TodoDatabase {
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            "todo_database"
        ).build()
    }

    @Provides
    fun provideTodoDao(db: TodoDatabase): TodoDao = db.todoDao()

    @Provides
    @Singleton
    fun provideTodoRepository(
        dao: TodoDao
    ): TodoRepository {
         return TodoRepositoryImpl(
             dao
         )
    }



}