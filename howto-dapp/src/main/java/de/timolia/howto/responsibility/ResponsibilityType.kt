package de.timolia.howto.responsibility

enum class ResponsibilityType {
    HV,
    NV;

    fun defaultKey(): String {
        return "%page.responsibilities.${name.lowercase()}%"
    }
}
