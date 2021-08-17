package com.patient.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.patient.Bean.Patient;
import com.patient.util.DbConnection;
import com.patient.util.PatientConstant;

public class PatientDao
{
	private static final String ADMIN = "admin";

	public List<Patient> getPatients() throws Exception
	{
		Connection con = null;
		try
		{
			con = DbConnection.getConnection();
			String sql = "SELECT * FROM patient_details";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			List<Patient> list = new ArrayList<Patient>();
			while (rs.next())
			{
				Patient patients = new Patient();
				patients.setPatientId(rs.getInt(PatientConstant.ID));
				patients.setFirstName(rs.getString(PatientConstant.PATIENT_FIRST_NAME));
				patients.setMiddleName(rs.getString(PatientConstant.PATIENT_MIDDLE_NAME));
				patients.setLastName(rs.getString(PatientConstant.PATIENT_LAST_NAME));
				patients.setGender(rs.getString(PatientConstant.GENDER));
				patients.setAge(rs.getInt(PatientConstant.AGE));
				patients.setBloodGroup(rs.getString(PatientConstant.BLOOD_GROUP));
				patients.setContactNumber(rs.getLong(PatientConstant.CONTACT_NUMBER));
				patients.setCreatedBy(rs.getString(PatientConstant.CREATED_BY));
				patients.setCreatedOn(rs.getDate(PatientConstant.CREATED_ON));
				patients.setModifiedBy(rs.getString(PatientConstant.MODIFIED_BY));
				patients.setModifiedOn(rs.getDate(PatientConstant.MODIFIED_ON));
				list.add(patients);
			}
			return list;
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception(e);
		}

	}

	public void savePatient(Patient patient) throws Exception
	{
		try
		{
			Connection con = DbConnection.getConnection();
			String sql = "INSERT into patient_details(first_name,middle_name,last_name,age,gender,blood_group,contact_number,created_by,created_on,modified_by,modified_on,is_deleted)values(?,?,?,?,?,?,?,?,GETDATE(),?,GETDATE(),?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, patient.getFirstName());
			pst.setString(2, patient.getMiddleName());
			pst.setString(3, patient.getLastName());
			pst.setInt(4, patient.getAge());
			pst.setString(5, patient.getGender());
			pst.setString(6, patient.getBloodGroup());
			pst.setLong(7, patient.getContactNumber());
			pst.setString(8, PatientDao.ADMIN);
			pst.setString(9, PatientDao.ADMIN);
			pst.setInt(10, 0);
			pst.executeUpdate();

		} catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception();

		}

	}

	public void updatePateint(Patient patient) throws Exception
	{
		try
		{
			Connection con = DbConnection.getConnection();
			String sql = "UPDATE patient_details SET first_name=?,middle_name=?,last_name=?,age=?,gender=?,blood_group=?,contact_number=?,modified_by=?,modified_on=GETDATE() WHERE id=? and is_deleted=0";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, patient.getFirstName());
			pst.setString(2, patient.getMiddleName());
			pst.setString(3, patient.getLastName());
			pst.setInt(4, patient.getAge());
			pst.setString(5, patient.getGender());
			pst.setString(6, patient.getBloodGroup());
			pst.setLong(7, patient.getContactNumber());
			pst.setString(8, PatientDao.ADMIN);
			pst.setInt(9, patient.getPatientId());

			System.out.println(pst.executeUpdate());

		} catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception(e);
		}

	}

	public void deletePatient(int patientId) throws Exception
	{
		try
		{
			Connection con = DbConnection.getConnection();
			String sql = "UPDATE patient_details SET is_deleted=? WHERE id=? and is_deleted = 0";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, 1);
			pst.setInt(2, patientId);
			pst.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception(e);
		}
	}

}
