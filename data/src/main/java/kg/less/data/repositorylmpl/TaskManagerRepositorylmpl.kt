package kg.less.data.repositorylmpl

import kg.less.data.database.dao.TaskManagerDao
import java.util.concurrent.Flow

class TaskManagerRepositorylmpl(
    private val taskManagerDao: TaskManagerDao
) : TaskManagerRepository {
    override suspend fun getTask(id: Int): Result<TaskModel> {
        try {
            val data = taskManagerDao.getTaskById(id)
            return Result.Success(data.toDomain())
        } catch (ex: Exception) {
            return Result.Error(ex.message.toString())
        }
    }

    override suspend fun insertTask(taskModel: TaskModel): Result<TaskModel> {
        return try {
            taskManagerDao.insertTask(taskModel.toData())
            Result.Success(taskModel)
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }

    override suspend fun getAllTasks(): Flow<Result<List<TaskModel>>> {
        return taskManagerDao.getAllTasks().map { list ->
            try {
                Result.Success(list.map { dto -> dto.toDomain })
            } catch (e: Exception) {
                Result.Error(e.message.toString())
            }
        }
    }

    override suspend fun getTaskByName(taskName: String): Result<TaskModel> {
        return try {
            val task = taskManagerDao.getTaskByName(taskName).toDomain()
            Result.Succes(task)
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }

    override suspend fun updateTask(taskModel: TaskModel): Result<TaskModel> {
        return try {
            taskManagerDao.updateTask(taskModel.toData())
            Result.Seccess(taskModel)
        } catch (e: Exception) {
            Result.Error(e.localizedMessage ?: "Error updating task")
        }
    }

    override suspend fun deleteTask(task: TaskModel): Result<TaskModel> {
        return try {
            taskManagerDao.deleteTask(task.toData())
            Result.Success(task)
        }catch (e: Exception) {
            Result.Error(e.localizedMessage?: "Error deleting task")
        }
    }
}