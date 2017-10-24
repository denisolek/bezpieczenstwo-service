package com.denisolek.bezpieczenstwo_service.repository

import com.denisolek.bezpieczenstwo_service.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Int> {
    fun findByUsername(username: String): User?
}