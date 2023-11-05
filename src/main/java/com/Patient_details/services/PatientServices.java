package com.Patient_details.services;

import java.util.List;

import com.Patient_details.entity.Patient;
import com.Patient_details.excptions.MyException;

public interface PatientServices {
	
	Patient createPatient(Patient patient);
	Patient updatePatient(Patient updatePatient,String patientId) throws MyException;
	void deletePatient(String patientId) throws MyException;
	List<Patient> getAllPatients();
	Patient seeSinglePatient(String patientId) throws MyException;
}
