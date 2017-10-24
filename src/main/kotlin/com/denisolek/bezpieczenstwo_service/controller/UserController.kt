package com.denisolek.bezpieczenstwo_service.controller

import com.denisolek.bezpieczenstwo_service.config.security.AuthorizationService
import com.denisolek.bezpieczenstwo_service.controller.dto.MessageDTO
import com.denisolek.bezpieczenstwo_service.controller.dto.UserDTO
import com.denisolek.bezpieczenstwo_service.controller.dto.UserInfoDTO
import com.denisolek.bezpieczenstwo_service.entity.User
import com.denisolek.bezpieczenstwo_service.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import javax.validation.Valid

@RestController
class UserController(private val userRepository: UserRepository,
                     private val passwordEncoder: PasswordEncoder,
                     private val authorizationService: AuthorizationService) {
    companion object {
        const val API_PATH = "/api"
        const val USERS_PATH = "$API_PATH/users"
    }

    @PostMapping(USERS_PATH)
    @ResponseStatus(HttpStatus.CREATED)
    fun addUser(@RequestBody @Valid userDTO: UserDTO) {
        val newUser = User(userDTO).copy(
                password = passwordEncoder.encode(userDTO.password)
        )
        userRepository.save(newUser)
    }

    @GetMapping(USERS_PATH)
    fun getUser(): UserInfoDTO =
            UserInfoDTO.fromUser(authorizationService.getCurrentUser())

    @PutMapping(USERS_PATH)
    fun updateUser(@RequestBody @Valid messageDTO: MessageDTO): UserInfoDTO {
        val updatedUser = authorizationService.getCurrentUser().copy(
                message = messageDTO.content,
                messageDate = LocalDateTime.now()
        )
        return UserInfoDTO.fromUser(userRepository.save(updatedUser))
    }
}