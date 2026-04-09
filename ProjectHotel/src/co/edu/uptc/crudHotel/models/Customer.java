package co.edu.uptc.crudHotel.models;

import java.util.Date;

public class Customer extends Person{
	private int numberRoomers;

	public Customer(int id, String name, Date birthDate, String phoneNumber, String email, String dni,
			int numberRoomers) {
		super(id, name, birthDate, phoneNumber, email, dni);
		this.numberRoomers = numberRoomers;
	}

	public int getNumberRoomers() {
		return numberRoomers;
	}

	public void setNumberRoomers(int numberRoomers) {
		this.numberRoomers = numberRoomers;
	}
}
