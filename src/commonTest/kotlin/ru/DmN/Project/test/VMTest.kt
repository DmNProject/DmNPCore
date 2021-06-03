package ru.DmN.Project.test

import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine
import kotlin.test.Test

class VMTest {
    /**
     *
     */
    inline val NOP get() = 0

    /**
     * Set Stack Size
     */
    inline val SSS get() = 1

    /**
     * Create Object
     */
    inline val CO0 get() = 2

    /**
     * Create Object
     */
    inline val CO1 get() = 3

    /**
     * Get Function
     */
    inline val GF0 get() = 4

    /**
     * Get Function
     */
    inline val GF1 get() = 5

    /**
     * Call
     */
    inline val C0 get() = 6

    /**
     * Call
     */
    inline val C1 get() = 7

    /**
     * Call
     */
    inline val C2 get() = 8

    /**
     * Call
     */
    inline val C3 get() = 9

    @Test
    fun test() {
        val vm = DynamicVirtualMachine()
        //
        vm.init()
        //
        vm.eval(intArrayOf(
            SSS, 1,
            CO1, 1, 0, 13, 72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100, 33,
            C3, 0, 7, 112, 114, 105, 110, 116, 108, 110
        ))
    }
}