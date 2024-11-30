package kg.less.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskDto::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskManagerDao(): TaskManagerDao
}