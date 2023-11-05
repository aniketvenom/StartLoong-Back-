package com.Patient_details.servicesImple;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Patient_details.entity.Patient;
import com.Patient_details.excptions.MyException;
import com.Patient_details.repository.PatientRepository;
import com.Patient_details.services.PatientServices;
import com.Patient_details.utils.ObjectConverter;

@Service
public class PatientServicesImpl implements PatientServices {

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	ObjectConverter objConverter;

	@Override
	public Patient createPatient(Patient patient) {

		StringBuffer phoneNumber = new StringBuffer(patient.getPhone());
		patient.setDate(LocalDate.now());
		patient.setPetientId("P" + phoneNumber.reverse());
		patientRepository.save(patient);
		return patient;
	}

	@Override
	public Patient updatePatient(Patient updatePatient, String patientId) throws MyException {

		Patient oldPatient = patientRepository.findByPetientId(patientId)
				.orElseThrow(() -> new MyException("Patient Not Found with this Patient Id"));

		oldPatient.setAffectedSide(updatePatient.getAffectedSide());
		oldPatient.setAge(updatePatient.getAge());
		oldPatient.setCon(updatePatient.getCon());
		oldPatient.setEmail(updatePatient.getEmail());
		oldPatient.setGender(updatePatient.getGender());
		oldPatient.setMedicalHistory(updatePatient.getMedicalHistory());
		oldPatient.setName(updatePatient.getName());
		oldPatient.setPhone(updatePatient.getPhone());
		oldPatient.setSpeciality(updatePatient.getSpeciality());

		patientRepository.save(oldPatient);

		return oldPatient;
	}

	@Override
	public void deletePatient(String patientId) throws MyException {
		Patient patient = patientRepository.findByPetientId(patientId)
				.orElseThrow(() -> new MyException("Patient Not Found with this Patient Id "));

		objConverter.patientToRecycleBinConverter(patient);

		patientRepository.delete(patient);

	}

	@Override
	public List<Patient> getAllPatients() {

		return patientRepository.findAll();
	}

	@Override
	public Patient seeSinglePatient(String patientId) throws MyException {
		Patient patient =  patientRepository.findByPetientId(patientId).orElseThrow(()->
		new MyException("Patient Not Found With this Patient id"));
		return patient;
	}

}
