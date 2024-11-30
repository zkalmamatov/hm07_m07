package kg.less.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskDto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val taskName: String? = null,
    val taskDate: String? = null,
    val taskImage: String? = null
)

fun TaskModel.toData() = TaskDto(id, taskName, taskDate, taskImage)
fun TaskDto.toDomain() = TaskModel(id, taskName.orEmpty(), taskDate.orEmpty(), taskImage.orEmpty())