package co.edu.uptc.crudHotel.models;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.crudHotel.enums.Category;

public class Hotel {
	private String name;
	private List<List<Room>> rooms;
	private List<Customer> customers;
	private List<Employee> employees;
	private List<Reservation> reservations;
	private String adress;
	private Category category;
	private String city;
	private String phoneNumber;
	private String email;
	
	public Hotel(String name, List<List<Room>> rooms, List<Customer> customers, List<Employee> employees,
			List<Reservation> reservations, String adress, Category category, String city, String phoneNumber,
			String email) {
		super();
		this.name = name;
		this.rooms = rooms;
		this.customers = customers;
		this.employees = employees;
		this.reservations = reservations;
		this.adress = adress;
		this.category = category;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<List<Room>> getRooms() {
		return rooms;
	}

	public void setRooms(List<List<Room>> rooms) {
		this.rooms = rooms;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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