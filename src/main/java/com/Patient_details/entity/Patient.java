package com.Patient_details.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 40, nullable = false)
	@NotNull(message="Name is required")
	@Size(min=3,message="Minimum 3 character are required")
	@Size(max=40,message="Maximum 40 character are allowed")
	private String name;

	@Column(length = 10, nullable = false)
	@NotNull(message="Gender is required")
	private String gender;

	@Column(nullable = false)
	@NotNull(message="age is required")
	private int age;

	@Column(length = 10, nullable = false, unique = true)
	@NotNull(message="Phone Number is required")
	@Pattern(regexp = "[6,7,8,9]{1}[0-9]{9}",message="Invalid Phone Number")
	@Size(min=10,message="10 character are required")
	@Size(max=10,message="10 character are required")
	private String phone;

	@Column(length = 50, nullable = false, unique = true)
	@NotNull(message="Email is required")
	@Email(message="Invalid Email")
	@Size(max=50,message="Maximum 50 character are allowed")
	private String email;

	@Column(length = 17, nullable = false, unique = true)
	private String petientId;

	@Column(length=50,nullable=false)
	@NotNull(message="Affected side is required")
	@Size(min=3,message="Minimum 3 character are required")
	@Size(max=50,message="Maximum 50 character are allowed")
	private String affectedSide;
	
	@Column(length=50,nullable=false)
	@NotNull(message="Condition is required")
	@Size(min=3,message="Minimum 3 character are required")
	@Size(max=50,message="Maximum 50 character are allowed")
	private String con;
	
	@Column(length=50,nullable=false)
	@NotNull(message="Speciality is required")
	@Size(min=3,message="Minimum 3 character are required")
	@Size(max=50,message="Maximum 50 character are allowed")
	private String speciality;
	
	@Column(length=50,nullable=false)
	@NotNull(message="Medical History is required")
	@Size(min=3,message="Minimum 3 character are required")
	@Size(max=50,message="Maximum 50 character are allowed")
	private String medicalHistory;
	
	@Column(nullable=false)
	private LocalDate date;
	


	
}
