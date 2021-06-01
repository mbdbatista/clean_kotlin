package src.framework.security

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import src.business.errors.AlreadyRegistered
import src.business.errors.NotFound

data class ApiError(
    val code: String,
    val message: String
)

@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(NotFound::class)
    fun handleEntityNotFound(exception: NotFound): ResponseEntity<ApiError> {
        return ResponseEntity(ApiError(code = "entity_not_found", message = exception.message), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(AlreadyRegistered::class)
    fun handleAlreadyRegistered(exception: AlreadyRegistered): ResponseEntity<ApiError> {
        return ResponseEntity(ApiError(code = "entity_already_registered", message = exception.message), HttpStatus.BAD_REQUEST)
    }
}