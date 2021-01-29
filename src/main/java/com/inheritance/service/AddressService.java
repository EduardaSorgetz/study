/**
 * 
 */
package com.inheritance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inheritance.error.ResourseNotFoundException;
import com.inheritance.model.Address;
import com.inheritance.repository.AddressRepository;

/**
 * @author eduardaalves
 *
 */
@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;
	
	public Address create(Address dto) {
		return this.repository.save(dto);
	}
	
	public Address update(Address dto) {
		this.verifyAddressExist(dto.getId());
		
		Address address = new Address();
		address.setCity(dto.getCity());
		address.setCountry(dto.getCountry());
		return this.repository.save(address);
	}
	
	public void verifyAddressExist(Long id) {
		Address address = this.repository.findById(id).get();
		if(address == null) {
			throw new ResourseNotFoundException("Id "+ id + " não encontrado na base de dados");
		}
	}
}
