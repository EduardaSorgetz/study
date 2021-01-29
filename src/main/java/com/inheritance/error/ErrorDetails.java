/**
 * 
 */
package com.inheritance.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author eduardaalves
 *
 */
@SuperBuilder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
	private String title;
	private int status;
	private String detail;
	private Long timestamp;
	private String developerMessage;
}
