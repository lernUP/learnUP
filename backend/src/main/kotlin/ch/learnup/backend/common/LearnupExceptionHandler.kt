package ch.learnup.backend.common

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class LearnupExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(LearnupAuthorizationException::class)
    fun handleUnauthorized(
        ex: LearnupAuthorizationException,
        request: WebRequest,
    ): ResponseEntity<Any>? = handleExceptionInternal(ex, ex.message, HttpHeaders(), HttpStatus.UNAUTHORIZED, request)
}
