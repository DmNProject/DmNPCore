package ru.DmN.Project.core.util

class AtomicInt(var value: Int = 0) {
    fun inc(): Int = ++value
}