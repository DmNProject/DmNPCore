package ru.DmN.Project.kvm.kayjamlang.parser

class Token(val value: String) { // TODO NEED TO CREATE
    companion object {
        // Comment's
        val TK_COMMENT_LN = Token("//")
        val TK_COMMENT_S = Token("/*")
        val TK_COMMENT_E = Token("*\\")
        // Namespace
        val TK_NAMESPACE_DELIMITER = Token("\\\\")
        // Reference
        val TK_REF = Token("->")
        // Access
        val TK_ACCESS = Token(".")
        val TK_ACCESS_COMPANION = Token("::")
        // Extends/Impl
        val TK_COMMA = Token(":")
        // New Command
        val TK_SEMA = Token(";")
        // Is Null?
        val TK_NULLABLE = Token("?")

    }
}