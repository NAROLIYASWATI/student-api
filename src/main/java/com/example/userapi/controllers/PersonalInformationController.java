package com.example.userapi.controllers;

import com.example.userapi.dao.entity.PersonalInformation;
import com.example.userapi.dao.repositories.PersonalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonalInformationController {

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    @RequestMapping(value = "/personal-info", method = RequestMethod.GET)
    public List<PersonalInformation> getPersonalInformation() {
        return (List<PersonalInformation>) personalInformationRepository.findAll();
    }

    @RequestMapping(value = "/personal-info/{id}", method = RequestMethod.GET)
    public PersonalInformation getPersonalInformation(@PathVariable("id") String id) {
        Long idLong = Long.parseLong(id);
        return personalInformationRepository.findById(idLong).get();
    }

    @RequestMapping(value = "/personal-info", method = RequestMethod.POST)
    public boolean addPersonalInformation(@RequestBody PersonalInformation personalInformation) {
        if (personalInformation != null && personalInformationRepository.save(personalInformation) != null) {
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/personal-info/{id}", method = RequestMethod.DELETE)
    public boolean deletePersonalInformation(@PathVariable("id") String id) {
        Long idLong = Long.parseLong(id);
        personalInformationRepository.deleteById(idLong);
        return true;
    }

    @RequestMapping(value = "/personal-info/{id}", method = RequestMethod.PUT)
    public boolean updatePersonalInformation(@PathVariable("id") String id, @RequestBody PersonalInformation personalInformation) {
        Long idLong = Long.parseLong(id);
        personalInformation.setSid(idLong);
        if (personalInformationRepository.save(personalInformation) != null) {
            return true;
        }
        return false;
    }


}
