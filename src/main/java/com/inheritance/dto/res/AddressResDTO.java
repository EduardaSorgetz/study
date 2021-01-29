/**
 * 
 */
package com.inheritance.dto.res;

import com.inheritance.model.Address;

import lombok.Builder;
import lombok.Data;

/**
 * @author eduardaalves
 *
 */
@Data
@Builder
public class AddressResDTO {
	private Long id;
	private String city;
	private String country;
	
	public static AddressResDTO toRes(Address entity) {
		return AddressResDTO.builder()
				.id(entity.getId())
				.city(entity.getCity())
				.country(entity.getCountry())
				.build();
	}

}
