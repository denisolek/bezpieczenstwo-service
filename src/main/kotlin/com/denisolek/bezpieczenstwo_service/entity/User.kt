package com.denisolek.bezpieczenstwo_service.entity

import com.denisolek.bezpieczenstwo_service.controller.dto.UserDTO
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "[user]")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        @Column(updatable = false, nullable = false, unique = true)
        var username: String,

        var password: String,

        var message: String,

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "user_authority", joinColumns = arrayOf(JoinColumn(name = "username")), inverseJoinColumns = arrayOf(JoinColumn(name = "authority")))
        val authorities: Set<Authority>,

        var createdOn: LocalDateTime
) {
    constructor(dto: UserDTO) : this(
            username = dto.username,
            password = dto.password,
            message = dto.message,
            createdOn = LocalDateTime.now(),
            authorities = setOf(Authority(Authority.Role.ROLE_USER))
    )
}