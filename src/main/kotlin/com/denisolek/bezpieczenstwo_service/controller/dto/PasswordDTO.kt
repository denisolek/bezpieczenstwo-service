package com.denisolek.bezpieczenstwo_service.controller.dto

import org.hibernate.validator.constraints.NotBlank
import javax.validation.constraints.Pattern

class PasswordDTO(
        @field:NotBlank
        val oldPassword: String,

        @field:Pattern(regexp = "((?=.*\\d)(?=.*[a-zA-Z]).{8,32})", message = "Password requires 8-32 length and at least one of each: a-Z, 1-9")
        val newPassword: String,

        @field:NotBlank
        val content: String
)