package ru.DmN.Project.kvm.test

import org.apache.commons.lang3.time.StopWatch
import org.junit.Test
import ru.DmN.Project.lvm.vm.LightVirtualMachine

class LVMSpeedTest {
    @Test
    fun test() {
        //
        val code = byteArrayOf(
            0x1, 0x1,
            0x3, 0x1, 0x0, 0xD, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x2C, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64, 0x21,
            0x9, 0x0, 0x7, 0x70, 0x72, 0x69, 0x6E, 0x74, 0x6C, 0x6E
        )
        //
        val vm = LightVirtualMachine()
        //
        vm.init()
        //
        val sw = StopWatch()
        sw.start()
        //
        sw.suspend()
        for (i in 0..999) {
            sw.resume()
            vm.eval(code)
            sw.suspend()
        }
        //
        sw.stop()
        println(sw)
    }
}