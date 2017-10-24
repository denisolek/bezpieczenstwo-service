package com.denisolek.bezpieczenstwo_service.controller.dto

import org.hibernate.validator.constraints.NotBlank

class MessageDTO(
        @field:NotBlank
        val content: String
)