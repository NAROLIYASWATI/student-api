package com.example.userapi.dao.repositories;

import com.example.userapi.dao.entity.AcademicHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicHistoryRepository extends CrudRepository<AcademicHistory,Long> {
}
