package co.edu.uptc.crudHotel.models;

import java.util.Date;

import co.edu.uptc.crudHotel.Logic.BaseClass;

public class Reservation extends BaseClass{
	private Room room;
	private Customer customer;
	private Date arrivalDate;
	private int reservedDays;

	public Reservation(int id, Room room, Customer customer, Date arrivalDate, int reservedDays) {
		super(id);
		this.room = room;
		this.customer = customer;
		this.arrivalDate = arrivalDate;
		this.reservedDays = reservedDays;
	}

	/*METODOS*/

	/*Asignar asociaciones*/
	/*Calcular costo total*/


	/*GETTERS AND SETTERS*/

	public Room getRoom() {
		return room;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public void setReservedDays(int reservedDays) {
		this.reservedDays = reservedDays;
	}

	public int getReservedDays() {
		return reservedDays;
	}


}
