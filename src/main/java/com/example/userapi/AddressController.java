package com.example.userapi;

import com.example.userapi.dao.entity.AddressRepository;
import com.example.userapi.dao.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

	@Autowired
	AddressRepository addressRepository;

	@RequestMapping("/address")
	public List<Address> getAddress() {
		return (List<Address>) addressRepository.findAll();
	}
	
	@RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
	public Address addAddress(@PathVariable("id") String id) {
		Long idLong=Long.parseLong(id);
		return addressRepository.findById(idLong).get();
	}

	@RequestMapping(value = "/address", method = RequestMethod.POST)
	public boolean addAddresss(@RequestBody Address address) {
		if (address != null) {
			if (addressRepository.save(address) != null) {
				return true;
			}
		}
		return false;
	}

	@RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
	public boolean deleteAddress(@PathVariable("id") String id) {
		Long idLong=Long.parseLong(id);
		addressRepository.deleteById(idLong);
		return true;
	}

	@RequestMapping(value = "/address/{id}", method = RequestMethod.PUT)
	public boolean updateAddresss(@PathVariable("id") String id, @RequestBody Address address) {
		Long idLong=Long.parseLong(id);
		address.setAid(idLong);
		if (addressRepository.save(address) != null) {
			return true;
		}
		return false;
	}


}
