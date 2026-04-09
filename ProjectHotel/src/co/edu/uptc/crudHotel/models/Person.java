package co.edu.uptc.crudHotel.models;

import java.util.Date;

import co.edu.uptc.crudHotel.Logic.BaseClass;

public class Person extends BaseClass{
	protected String name;
	protected Date birthDate;
	protected String phoneNumber;
	protected String email;
	protected String dni;

	public Person(int id, String name, Date birthDate, String phoneNumber, String email, String dni) {
		super(id);
		this.name = name;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
