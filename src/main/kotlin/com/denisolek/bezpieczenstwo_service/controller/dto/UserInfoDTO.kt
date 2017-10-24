package com.denisolek.bezpieczenstwo_service.controller.dto

import com.denisolek.bezpieczenstwo_service.entity.User
import java.time.LocalDateTime

class UserInfoDTO(
        var username: String,
        var message: String,
        var messageDate: LocalDateTime
) {
    companion object {
        fun fromUser(user: User) =
                UserInfoDTO(
                        username = user.username,
                        message = user.message,
                        messageDate = user.messageDate
                )
    }
}