package ru.DmN.Project.kvm.common.obj.api

import ru.DmN.Project.core.data.obj.api.IDS
import ru.DmN.Project.core.data.obj.api.IES
import ru.DmN.Project.core.obj.IDO
import ru.DmN.Project.core.obj.IEO
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine

open class KObject(override val name: String,
                   override val type: ObjType,
                   override val defines: IDS<IObject>,
                   override val extends: IES<IObject>,
                   override val functions: IFS<DynamicVirtualMachine, KObject>
) : IEO<IObject>, IDO<IObject>, IFunctionsContainer<DynamicVirtualMachine, KObject>