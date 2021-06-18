package ru.DmN.Project.kvm.common.vm.api

import ru.DmN.Project.core.data.api.IDS
import ru.DmN.Project.core.data.api.IES
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.vm.IVirtualMachine
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.KObject

abstract class KVM<C, V : KVM<C, V, O>, O : IObject>(name: String, defines: IDS<O>, functions: IFS<C, V, O>, extends: IES<O>) : IKTSVM<C, V, O>, KObject<C, V, O>(name, KawaiiType.VM, defines, functions, extends)