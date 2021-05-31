package ru.DmN.Project.kvm.common.utils

class AtomicInt(var i: Int = 0) {
    fun inc(): Int = ++i
    fun dec(): Int = --i
}