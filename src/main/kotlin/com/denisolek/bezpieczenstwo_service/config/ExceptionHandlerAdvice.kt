package com.denisolek.bezpieczenstwo_service.config

import javassist.tools.web.BadHttpRequest
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ExceptionHandlerAdvice {
    @ExceptionHandler(DataIntegrityViolationException::class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ResponseBody
    fun requestHandlerDataIntegrityViolationException() {
    }

    @ExceptionHandler(BadHttpRequest::class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun requestHandlerBadRequest() {
    }
}