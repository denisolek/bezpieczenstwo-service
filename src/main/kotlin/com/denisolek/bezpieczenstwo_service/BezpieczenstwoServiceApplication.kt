package com.denisolek.bezpieczenstwo_service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@SpringBootApplication
class BezpieczenstwoServiceApplication {
    @Autowired
    private val userDetailsService: UserDetailsService? = null

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(BezpieczenstwoServiceApplication::class.java, *args)
        }
    }

    @Autowired
    @Throws(Exception::class)
    fun authenticationManager(builder: AuthenticationManagerBuilder) {
        builder.userDetailsService<UserDetailsService>(userDetailsService).passwordEncoder(passwordEncoder())
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
