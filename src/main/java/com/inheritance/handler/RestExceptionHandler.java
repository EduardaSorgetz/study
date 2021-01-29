/**
 * 
 */
package com.inheritance.handler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.inheritance.error.ErrorDetails;
import com.inheritance.error.ResourceNotFoundDetails;
import com.inheritance.error.ResourseNotFoundException;
import com.inheritance.error.ValidationErrorDetails;

/**
 * @author eduardaalves
 *
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	private List<FieldError> fieldErrors;

	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourseNotFoundException rnfException) {
		ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.builder()
				.timestamp(new Date()
				.getTime())
				.status(HttpStatus.NOT_FOUND.value())
				.title("Resource not found")
				.detail("Resource not found")
				.developerMessage(rnfException.getClass().getName())
				.build();
		return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException manvException, HttpHeaders headers, HttpStatus status, WebRequest request) {
		fieldErrors = manvException.getBindingResult().getFieldErrors();
		String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
		String fieldsMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
		
		ValidationErrorDetails rnfDetails = ValidationErrorDetails.builder()
				.timestamp(new Date()
						.getTime())
				.status(HttpStatus.BAD_REQUEST.value())
				.title("Field validation error")
				.detail("Field validation error")
				.developerMessage(manvException.getClass().getName())
				.field(fields)
				.fieldMessage(fieldsMessages)
				.build();
		return new ResponseEntity<>(rnfDetails, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(
			Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDetails errorDetails = ErrorDetails.builder()
				.timestamp(new Date()
				.getTime())
				.status(status.value())
				.title("Internal Exception")
				.detail("Internal Exception")
				.developerMessage(ex.getClass().getName())
				.build();
		return new ResponseEntity<>(errorDetails, headers, status);
	}

}
