package com.Patient_details.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RecycleBin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 40)
	private String name;

	@Column(length = 10)
	private String gender;

	@Column(nullable = false)
	private int age;

	@Column(length = 10)
	private String phone;

	@Column(length = 50)
	private String email;

	@Column(length = 17)
	private String petientId;

	@Column(length = 50)

	private String affectedSide;

	@Column(length = 50)

	private String con;

	@Column(length = 50)

	private String speciality;

	@Column(length = 50)

	private String medicalHistory;

	@Column()
	private LocalDate date;

}
