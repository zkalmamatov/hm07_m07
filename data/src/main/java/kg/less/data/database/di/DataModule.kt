package kg.less.data.database.di

import androidx.room.Room
import kg.less.data.database.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

val dataModules: Module = module {

    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "TaskDataBase")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().taskManagerDao() }

    single<TaskManagerRepository> { TaskManagerRepositoryImpl(get()) }
}