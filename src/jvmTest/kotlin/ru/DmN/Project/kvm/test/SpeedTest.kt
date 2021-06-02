package ru.DmN.Project.kvm.test

import org.apache.commons.lang3.time.StopWatch
import org.junit.Test
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.api.Function

class SpeedTest {
    @Test
    fun test() {
        val sw = StopWatch()
        sw.start()
        //
        val ifs = IFSImpl()
        for (i in 0..999) {
            ifs.add(object : Function() {
                override val name: String = "o$i"
            })
        }
        //
        for (i in 0..999) {
            ifs.get("o$i", null)
        }
        //
        sw.stop()
        println(sw)
    }
}