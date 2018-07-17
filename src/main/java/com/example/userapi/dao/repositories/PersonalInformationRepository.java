package com.example.userapi.dao.repositories;

import com.example.userapi.dao.entity.PersonalInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInformationRepository extends CrudRepository<PersonalInformation,Long> {
}
