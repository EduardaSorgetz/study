/**
 * 
 */
package com.inheritance.error;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * @author eduardaalves
 *
 */
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper=false)
public class ValidationErrorDetails extends ErrorDetails{
	private String field;
	private String fieldMessage;
}
