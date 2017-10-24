package com.denisolek.bezpieczenstwo_service.entity

import javax.persistence.*

@Entity
@Table(name = "[user]")
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        @Column(updatable = false, nullable = false)
        var username: String,

        var password: String,

        var message: String,

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "user_authority", joinColumns = arrayOf(JoinColumn(name = "username")), inverseJoinColumns = arrayOf(JoinColumn(name = "authority")))
        val authorities: Set<Authority>
)