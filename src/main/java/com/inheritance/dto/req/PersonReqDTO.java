/**
 * 
 */
package com.inheritance.dto.req;

import java.util.List;

import com.inheritance.model.Person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author eduardaalves
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonReqDTO {
	private String firstName;
	private String lastName;
	private List<AddressReqDTO> address;

	public Person toEntity(Person person) {
		person.setFirstName(this.firstName);
		person.setLastName(this.lastName);
	
		return person;
}}
