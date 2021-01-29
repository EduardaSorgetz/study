/**
 * 
 */
package com.inheritance.dto.res;

import java.util.List;
import java.util.stream.Collectors;

import com.inheritance.model.Person;

import lombok.Builder;
import lombok.Data;

/**
 * @author eduardaalves
 *
 */
@Data
@Builder
public class PersonResDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private List<AddressResDTO> address;
	
	
	public static PersonResDTO toRes(Person entity) {
		return PersonResDTO.builder()
		.id(entity.getId())
		.firstName(entity.getFirstName())
		.lastName(entity.getLastName())
		.address(entity.getAddress().stream().map(AddressResDTO::toRes).collect(Collectors.toList()))
		.build();
	}
}
