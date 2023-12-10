package de.timolia.howto.conversion

import java.util.*

class TeamlerResponsibilities(
        private val name: String?,
        val hv: String?,
        val nv: String?
) {
    val uuid: UUID = SQLApi.getUuid(name)!!

    override fun toString(): String {
        return "TeamlerResponsibilities{" +
                "name='" + name + '\'' +
                ", uuid=" + uuid +
                ", hv='" + hv + '\'' +
                ", nv='" + nv + '\'' +
                '}'
    }
}
