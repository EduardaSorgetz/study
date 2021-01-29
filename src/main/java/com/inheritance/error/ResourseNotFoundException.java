/**
 * 
 */
package com.inheritance.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author eduardaalves
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourseNotFoundException(String message) {
		super(message);
	}


}
