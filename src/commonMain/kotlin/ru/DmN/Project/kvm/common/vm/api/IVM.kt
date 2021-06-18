package ru.DmN.Project.kvm.common.vm.api

import ru.DmN.Project.core.obj.IDO
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.vm.IVirtualMachine
import ru.DmN.Project.kvm.common.obj.api.IFunctionsContainer

interface IVM<C, V : IVM<C, V, O>, O : IObject> : IVirtualMachine<C>, IDO<O>, IFunctionsContainer<C, V, O>