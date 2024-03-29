package com.denisolek.bezpieczenstwo_service.entity

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id

@Entity
class Authority(@Id
                @Enumerated(EnumType.STRING)
                val role: Role) {

    enum class Role {
        ROLE_USER,
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Authority

        if (role != other.role) return false

        return true
    }

    override fun hashCode(): Int {
        return role.hashCode()
    }
}