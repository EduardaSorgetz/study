/**
 * 
 */
package com.inheritance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.inheritance.dto.req.PersonReqDTO;
import com.inheritance.dto.res.PersonResDTO;
import com.inheritance.error.ResourseNotFoundException;
import com.inheritance.error.ValidationErrorException;
import com.inheritance.model.Address;
import com.inheritance.model.Person;
import com.inheritance.repository.PersonRepository;

/**
 * @author eduardaalves
 *
 */
@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	@Autowired
	private AddressService AddressService;

	public PersonResDTO save(PersonReqDTO dto) {
		Person person = dto.toEntity(new Person());
		List<Address> addressList = new ArrayList<>();

		if (dto.getAddress() != null && !dto.getAddress().isEmpty()) {
			dto.getAddress().forEach(address -> {
				if (!address.getCity().isEmpty() || !address.getCountry().isEmpty()) {
					addressList.add(this.AddressService.create(address.toEntity(new Address())));
				} else {
					throw new ValidationErrorException("Verifique os campos obrigatórios");
				}
			});
		} else {
			throw new ValidationErrorException("Verifique os campos obrigatórios");
		}

		person.setAddress(addressList);
		return PersonResDTO.toRes(this.repository.save(person));
	}

	public void verifyPersonExist(Long id) {
		if (!this.repository.findById(id).isPresent()) {
			throw new ResourseNotFoundException("Id "+ id + " não encontrado na base de dados");
		}
	}

	public PersonResDTO update(Long id, PersonReqDTO dto) {
		this.verifyPersonExist(id);
		Person person = this.repository.findById(id).get();
		List<Address> addressList = new ArrayList<>();

		if (dto.getAddress() != null && !dto.getAddress().isEmpty()) {
			dto.getAddress().forEach(address -> {
				if (!address.getCity().isEmpty() || !address.getCountry().isEmpty()) {
					addressList.add(this.AddressService.update(address.toEntity(new Address())));
				} else {
					throw new ValidationErrorException("Verifique os campos obrigatórios");
				}
			});
		} else {
			throw new ValidationErrorException("Verifique os campos obrigatórios");
		}

		person.setFirstName(dto.getFirstName());
		person.setLastName(dto.getLastName());

		return PersonResDTO.toRes(person);
	}

	public void logicalExclusion(Long id) {
		this.verifyPersonExist(id);
		this.repository.deleteById(id);
	}

	/**
	 * @param id
	 * @return
	 */
	public PersonResDTO findById(Long id) {
		this.verifyPersonExist(id);
		Person person = this.repository.findById(id).get();
		return PersonResDTO.toRes(person);
	}

	/**
	 * @param page
	 * @return
	 */
	public Page<Person> findAll(Pageable query) {
		return this.repository.findAll(query);

	}
}
