package br.com.alura.forum.exceptions

import br.com.alura.forum.dtos.ErrorView
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

  @ExceptionHandler(NotFoundException::class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  fun handleNotFound(e: NotFoundException, request: HttpServletRequest): ErrorView {
    return ErrorView(
      status = HttpStatus.NOT_FOUND.value(),
      error = HttpStatus.NOT_FOUND.name,
      message = e.message,
      path = request.servletPath,
    );
  }

  @ExceptionHandler(MethodArgumentNotValidException::class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  fun handleValidateError(e: MethodArgumentNotValidException, request: HttpServletRequest): ErrorView {
    val errorMessage: HashMap<String, String?> = HashMap<String, String?>();

    e.bindingResult.fieldErrors.map { e -> errorMessage.put(e.field, e.defaultMessage) }

    return ErrorView(
      status = HttpStatus.BAD_REQUEST.value(),
      error = HttpStatus.BAD_REQUEST.name,
      message = errorMessage.toString(),
      path = request.servletPath,
    );
  }

  @ExceptionHandler(Exception::class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  fun handleServer(e: Exception, request: HttpServletRequest): ErrorView {
    return ErrorView(
      status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
      error = HttpStatus.INTERNAL_SERVER_ERROR.name,
      message = e.message,
      path = request.servletPath,
    );
  }
}