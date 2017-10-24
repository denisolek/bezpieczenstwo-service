package com.denisolek.bezpieczenstwo_service.controller

import com.denisolek.bezpieczenstwo_service.controller.dto.UserDTO
import com.denisolek.bezpieczenstwo_service.entity.User
import com.denisolek.bezpieczenstwo_service.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class UserController(private val userRepository: UserRepository,
                     private val passwordEncoder: PasswordEncoder) {
    companion object {
        const val API_PATH = "/api"
        const val USERS_PATH = "$API_PATH/users"
    }

    @PostMapping(USERS_PATH)
    @ResponseStatus(HttpStatus.CREATED)
    fun addUser(@RequestBody @Valid userDTO: UserDTO) {
        userRepository.save(User(userDTO).copy(
                password = passwordEncoder.encode(userDTO.password))
        )
    }
}