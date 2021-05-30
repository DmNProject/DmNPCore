package ru.DmN.Project.core.vm

/**
 * (EN) Template for offer machine zero level
 * @param T (EN) The type of code that will be executed by the virtual machine
 */
interface IVirtualMachine<T> {
    /**
     * (EN) Virtual machine initialization function
     */
    fun init()

    /**
     * (EN) Code execution function
     * @param code Code to execute
     */
    fun eval(code: T)
}