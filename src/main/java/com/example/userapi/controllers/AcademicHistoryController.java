package com.example.userapi.controllers;

import com.example.userapi.dao.entity.AcademicHistory;
import com.example.userapi.dao.repositories.AcademicHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1")
public class AcademicHistoryController {

	@Autowired
	private AcademicHistoryRepository academicHistoryRepository;


	@RequestMapping(value = "/academic-history/", method = RequestMethod.GET)
	public List<AcademicHistory> getAcademicHistory() {
		return (List<AcademicHistory>) academicHistoryRepository.findAll();
	}
	
	@RequestMapping(value = "/academic-history/{id}", method = RequestMethod.GET)
	public AcademicHistory getAcademicHistory(@PathVariable("id") String id) {
		Long idLong=Long.parseLong(id);
		return academicHistoryRepository.findById(idLong).get();
	}

	@RequestMapping(value = "/academic-history", method = RequestMethod.POST)
	public boolean addAcademicHistory(@RequestBody AcademicHistory academicHistory) {
		if (academicHistory != null && academicHistoryRepository.save(academicHistory) != null) {
				return true;
		}
		return false;
	}

	@RequestMapping(value = "/academic-history/{id}", method = RequestMethod.DELETE)
	public boolean deleteAcademicHistory(@PathVariable("id") String id) {
		Long idLong=Long.parseLong(id);
		academicHistoryRepository.deleteById(idLong);
		return true;
	}

	@RequestMapping(value = "/academic-history/{id}", method = RequestMethod.PUT)
	public boolean updateAcademicHistory(@PathVariable("id") String id, @RequestBody AcademicHistory academicHistory) {
		Long idLong=Long.parseLong(id);
		academicHistory.setAcademicHistoryId(idLong);
        return academicHistoryRepository.save(academicHistory) != null? true:false;
	}
	

}
