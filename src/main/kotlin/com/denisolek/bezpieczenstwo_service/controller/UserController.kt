package com.denisolek.bezpieczenstwo_service.controller

import com.denisolek.bezpieczenstwo_service.controller.dto.UserDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class UserController {
    companion object {
        const val API_PATH = "/api"

        const val USERS_PATH = "$API_PATH/users"
    }

    @PostMapping(USERS_PATH)
    fun addUser(@RequestBody @Valid userDTO: UserDTO) {

        print(1)
    }
}