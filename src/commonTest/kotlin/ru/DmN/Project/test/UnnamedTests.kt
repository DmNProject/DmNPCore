package ru.DmN.Project.test

import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.KObject
import kotlin.test.Test

class UnnamedTests {
    @Test
    fun test() {
        println(KObject("test", KawaiiType.VAR).name == KObject("test", KawaiiType.VAR).name)
    }
}