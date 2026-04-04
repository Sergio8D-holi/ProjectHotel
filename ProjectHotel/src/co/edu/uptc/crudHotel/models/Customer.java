package co.edu.uptc.crudHotel.models;

import java.util.Date;

public class Customer extends Person{
	private int numberRoomers;

	public Customer(String name, Date birthDate, String phoneNumber, String email, String idNumber, int numberRoomers) {
		super(name, birthDate, phoneNumber, email, idNumber);
		this.numberRoomers = numberRoomers;
	}
	
}
