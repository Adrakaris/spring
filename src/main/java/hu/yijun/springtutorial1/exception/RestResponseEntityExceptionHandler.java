package hu.yijun.springtutorial1.exception;

import hu.yijun.springtutorial1.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	// when an exception is thrown in a @RestController, this @ControllerAdvice will catch that
	// and handle it

	@ExceptionHandler(DepartmentNotFoundException.class)  // must annotate
	public ResponseEntity<ErrorMessage> departmentNotFoundExcpetion(DepartmentNotFoundException exception,
													  WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,
				exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}

}
