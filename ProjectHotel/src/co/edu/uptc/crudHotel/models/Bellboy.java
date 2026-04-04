package co.edu.uptc.crudHotel.models;

import java.util.Date;

public class Bellboy extends Employee{
	protected boolean luggageRack;

	public Bellboy(String name, Date birthDate, String phoneNumber, String email, String idNumber, Date hireDate,
			boolean luggageRack) {
		super(name, birthDate, phoneNumber, email, idNumber, hireDate);
		this.luggageRack = luggageRack;
	}
}
