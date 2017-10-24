package com.denisolek.bezpieczenstwo_service.config.security

import com.denisolek.bezpieczenstwo_service.entity.User
import com.denisolek.bezpieczenstwo_service.repository.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import javax.persistence.EntityNotFoundException

@Component("userDetailsService")
class CustomUserDetailsService(private val userRepository: UserRepository) : org.springframework.security.core.userdetails.UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val lowercaseLogin = username.toLowerCase()

        val userFromDatabase: User = userRepository.findByUsername(lowercaseLogin) ?: throw EntityNotFoundException()

        val grantedAuthorities = ArrayList<GrantedAuthority>()

        userFromDatabase.authorities.mapTo(grantedAuthorities) { SimpleGrantedAuthority(it.role.toString()) }

        return org.springframework.security.core.userdetails.User(userFromDatabase.username, userFromDatabase.password, grantedAuthorities)
    }

}