package com.denisolek.bezpieczenstwo_service.config.security

import com.denisolek.bezpieczenstwo_service.entity.User
import com.denisolek.bezpieczenstwo_service.repository.UserRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class AuthorizationService(private val userRepository: UserRepository) {
    fun getCurrentUser(): User {
        val authentication = SecurityContextHolder.getContext().authentication
        if (authentication.name != null)
             return userRepository.findByUsername(authentication.name!!) ?: throw EntityNotFoundException()
        else
            throw EntityNotFoundException()
    }
}