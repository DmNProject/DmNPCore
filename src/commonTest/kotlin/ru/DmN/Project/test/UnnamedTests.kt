package ru.DmN.Project.test

import kotlin.test.Test

class UnnamedTests {
    @Test
    fun test() {
        for (e in "Hello, World!".encodeToByteArray())
            print("$e ")
        println("\n${"Hello, World!".length}")
    }
}