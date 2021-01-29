/**
 * 
 */
package com.inheritance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inheritance.dto.req.PersonReqDTO;
import com.inheritance.dto.res.PersonResDTO;
import com.inheritance.model.Person;
import com.inheritance.service.PersonService;

/**
 * @author eduardaalves
 *
 */
@RestController
@RequestMapping("test")
public class PersonController {

	@Autowired
	private PersonService service;
	
	@PostMapping
	public PersonResDTO save(@RequestBody PersonReqDTO dto) {
		return this.service.save(dto);
	}
	
	@GetMapping("/{id}")
	public PersonResDTO show(@PathVariable("id") Long id) {
		return this.service.findById(id);
	}
	
	@GetMapping
	public Page<Person> findAll(Pageable page) {
		return this.service.findAll(page);
	}
	
	@PutMapping("/{id}")
	public PersonResDTO update(@PathVariable("id") Long id, @RequestBody PersonReqDTO dto) {
		return this.service.update(id, dto);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.service.logicalExclusion(id);
	}

}
