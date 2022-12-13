package com.codelabs.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) {
        tasks.find { it.id == item.id }?.let {
            it.checked = checked
            val index = _tasks.indexOf(it)
            _tasks.remove(it)
            _tasks.add(index, it)
        }
    }


    private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i.") }
}