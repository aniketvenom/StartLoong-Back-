package com.Patient_details.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Patient_details.entity.Patient;
import com.Patient_details.excptions.MyException;
import com.Patient_details.services.PatientServices;

@RestController
@CrossOrigin("http://localhost:4200/")
public class PatientController {

	@Autowired
	PatientServices patientService;

	@PostMapping("/savePatient")
	public Patient savePatient(@Valid @RequestBody Patient patient) {
		return patientService.createPatient(patient);
	}
	
	@GetMapping("/getPatientsDetails")
	public List<Patient> getPatients()
	{
		return patientService.getAllPatients();
		
	}
	
	@PostMapping("/updatePatientWithId/{patientId}")
	public Patient updatePatient(@Valid @RequestBody Patient updatedpatient,@PathVariable("patientId") String patientId) throws MyException
	{
		return patientService.updatePatient(updatedpatient, patientId);
	}
	
	@DeleteMapping("/deletePatientWithId/{patientId}")
	public void deletePatient(@PathVariable("patientId") String patientId) throws MyException
	{
		patientService.deletePatient(patientId);
//		return new ResponseEntity<String>(("Patient has been deleted with the patient id "+patientId),HttpStatus.OK);
	}
	
	@GetMapping("/seeSinglePatient/{patientId}")
	public Patient seeSinglePatient(@PathVariable("patientId") String patientId) throws MyException
	{
		return patientService.seeSinglePatient(patientId);
	}
}
