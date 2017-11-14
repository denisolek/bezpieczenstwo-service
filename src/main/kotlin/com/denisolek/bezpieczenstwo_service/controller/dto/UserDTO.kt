package com.denisolek.bezpieczenstwo_service.controller.dto

import org.hibernate.validator.constraints.NotBlank
import javax.validation.constraints.Pattern

class UserDTO(
        @field:NotBlank
        val username: String,

        @field:Pattern(regexp = "((?=.*\\d)(?=.*[a-zA-Z]).{8,32})", message = "Password requires 8-32 length and at least one of each: a-Z, 1-9")
        val password: String,

        @field:NotBlank
        val message: String
)