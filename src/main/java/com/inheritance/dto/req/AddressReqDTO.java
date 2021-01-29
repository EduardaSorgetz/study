/**
 * 
 */
package com.inheritance.dto.req;

import com.inheritance.model.Address;

import lombok.Builder;
import lombok.Data;

/**
 * @author eduardaalves
 *
 */
@Data
@Builder
public class AddressReqDTO {
	private String city;
	private String country;
	
	public Address toEntity(Address address) {
		address.setCity(this.city);
		address.setCountry(this.country);
		
		return address;
	}
}
