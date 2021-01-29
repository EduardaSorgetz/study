/**
 * 
 */
package com.inheritance.error;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author eduardaalves
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationErrorException extends RuntimeException implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidationErrorException(String message) {
		super(message);
	}
}
