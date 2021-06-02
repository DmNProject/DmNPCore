package ru.DmN.Project.test

import ru.DmN.Project.kvm.common.obj.KawaiiType
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class UnnamedTests {
    @Test
    fun test() {
        assertEquals(KawaiiType.OBJ, KawaiiType.OBJ)
        assertNotEquals(KawaiiType.OBJ, KawaiiType.VAR)
        assertNotEquals(KawaiiType.VAR, KawaiiType())
    }
}