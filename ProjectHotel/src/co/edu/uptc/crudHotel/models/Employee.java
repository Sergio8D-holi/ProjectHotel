package co.edu.uptc.crudHotel.models;

import java.util.Date;

import co.edu.uptc.crudHotel.enums.EmployeeTypeEnum;

public class Employee extends Person{
	private Date hireDate;
	private EmployeeTypeEnum employeeType;

	public Employee(int id, String name, Date birthDate, String phoneNumber, String email, String dni, Date hireDate,
			EmployeeTypeEnum employeeType) {
		super(id, name, birthDate, phoneNumber, email, dni);
		this.hireDate = hireDate;
		this.employeeType = employeeType;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public EmployeeTypeEnum getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeTypeEnum employeeType) {
		this.employeeType = employeeType;
	}

}
