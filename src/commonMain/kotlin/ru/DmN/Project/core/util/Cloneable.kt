package ru.DmN.Project.core.util

interface Cloneable {
    @Throws(CloneErrorException::class)
    fun clone(): Cloneable
}