package com.patient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patient.Bean.Patient;
import com.patient.service.PatientService;

public class PatientRegistarartion extends HttpServlet
{
	private PatientService patientservice = new PatientService();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		PrintWriter pw = resp.getWriter();
		List<Patient> list;
		try
		{
			list = patientservice.getPatients();
			pw.print(list);
			pw.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws JsonParseException, JsonMappingException, IOException
	{
		BufferedReader reader = req.getReader();
		String line = null;
		String jsonStr = " ";
		while ((line = reader.readLine()) != null)
		{
			jsonStr = jsonStr + line;
		}
		ObjectMapper mapper = new ObjectMapper();
		Patient patient = mapper.readValue(jsonStr, Patient.class);
		try
		{
			patientservice.savePatient(patient);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		BufferedReader reader = req.getReader();
		String line = null;
		String jsonstr = "";
		while ((line = reader.readLine()) != null)
		{
			jsonstr = jsonstr + line;
		}
		ObjectMapper mapper = new ObjectMapper();
		Patient patient = mapper.readValue(jsonstr, Patient.class);
		try
		{
			System.out.println("======1=========" + patient);
			patientservice.updatePateint(patient);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse resp)

	{
		int patientId = Integer.parseInt(req.getParameter("patientId"));
		try
		{
			patientservice.deletePatient(patientId);
		} catch (Exception e)
		{
			e.printStackTrace();

		}
	}

}
