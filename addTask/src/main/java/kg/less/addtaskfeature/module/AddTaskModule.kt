package kg.less.addtaskfeature.module

import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val addTaskModule: Module = module {

    viewModel { AddTaskViewModel(get()) }
}
