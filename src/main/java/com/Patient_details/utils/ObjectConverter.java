package com.Patient_details.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.Patient_details.entity.Patient;
import com.Patient_details.entity.RecycleBin;
import com.Patient_details.excptions.MyException;

@Component
public class ObjectConverter {

	public RecycleBin patientToRecycleBinConverter(Patient p) throws MyException
	{
		RecycleBin rb = new RecycleBin();
		if(p == null)
		{
			throw new MyException("Patient is emplty");
		}
		BeanUtils.copyProperties(p, rb);
		return rb;
	}
}
