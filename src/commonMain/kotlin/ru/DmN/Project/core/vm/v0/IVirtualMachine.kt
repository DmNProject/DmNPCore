package ru.DmN.Project.core.vm.v0

interface IVirtualMachine<T> {
    fun init()
    fun eval(code: T)
}