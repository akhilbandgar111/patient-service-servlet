package com.patient.service;

import java.util.List;

import com.patient.Bean.Patient;
import com.patient.dao.PatientDao;

public class PatientService
{
	private PatientDao patientdao = new PatientDao();

	public List<Patient> getPatients() throws Exception
	{
		return patientdao.getPatients();

	}

	public void savePatient(Patient patient) throws Exception
	{
		patientdao.savePatient(patient);
	}

	public void updatePateint(Patient patient) throws Exception
	{
		System.out.println("=================2================" + patient);
		patientdao.updatePateint(patient);

	}

	public void deletePatient(int patientId) throws Exception
	{
		patientdao.deletePatient(patientId);

	}

}
