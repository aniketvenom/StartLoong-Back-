package com.Patient_details.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Patient_details.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	Optional<Patient> findByPetientId(String patientId);

//	Optional<Patient> findByPatientId(String patientId);

}
