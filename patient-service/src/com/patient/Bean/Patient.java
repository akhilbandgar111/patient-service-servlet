package com.patient.Bean;

import java.util.Date;

public class Patient
{
	private int patientId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private int age;
	private String bloodGroup;
	private long contactNumber;
	private String modifiedBy;
	private Date modifiedOn;
	private String createdBy;
	private Date createdOn;

	public int getPatientId()
	{
		return patientId;
	}

	public void setPatientId(int patientId)
	{
		this.patientId = patientId;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getMiddleName()
	{
		return middleName;
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getBloodGroup()
	{
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup)
	{
		this.bloodGroup = bloodGroup;
	}

	public long getContactNumber()
	{
		return contactNumber;
	}

	public void setContactNumber(long contactNumber)
	{
		this.contactNumber = contactNumber;
	}

	public String getModifiedBy()
	{
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy)
	{
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn()
	{
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn)
	{
		this.modifiedOn = modifiedOn;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public Date getCreatedOn()
	{
		return createdOn;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	@Override
	public String toString()
	{
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", gender="
				+ gender + ", age=" + age + ", bloodGroup=" + bloodGroup + ", contactNumber=" + contactNumber + ", modifiedBy=" + modifiedBy
				+ ", modifiedOn=" + modifiedOn + ", createdBy=" + createdBy + ", createdOn=" + createdOn + "]";
	}

}