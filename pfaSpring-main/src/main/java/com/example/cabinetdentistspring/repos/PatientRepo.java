package com.example.cabinetdentistspring.repos;

import com.example.cabinetdentistspring.models.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends CrudRepository<Patient, Integer> {
}
