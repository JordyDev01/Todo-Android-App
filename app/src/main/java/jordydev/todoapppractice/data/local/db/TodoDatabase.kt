package jordydev.todoapppractice.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import jordydev.todoapppractice.data.local.dao.TodoDao
import jordydev.todoapppractice.model.Todo


@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoDatabase() : RoomDatabase() {


    abstract fun todoDao(): TodoDao

}


