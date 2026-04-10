package co.edu.uptc.crudHotel.Logic;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import co.edu.uptc.crudHotel.enums.BedTypeEconomicEnum;
import co.edu.uptc.crudHotel.enums.EmployeeTypeEnum;
import co.edu.uptc.crudHotel.models.EconomicRoom;
import co.edu.uptc.crudHotel.models.Employee;

public class CrudEmployee extends AbstractCrud<Employee>{
	public List<Employee> listEmployees;

	public List<Employee> getListEmployees() {
		return listEmployees;
	}

	public CrudEmployee(String nameEntity, List<Employee> listEmployees) {
		super(nameEntity);
		this.listEmployees = listEmployees;
	}

	@Override
	protected boolean newRecord(Employee record) {
		if(this.findRecordById(record.getId()) == null) {
			this.listEmployees.add(record);
			return true;
		}
		return false;
	}

	@Override
	protected Employee findRecordById(int id) {
		return this.listEmployees.stream().filter(s -> s.getId() == id)
				.findAny().orElse(null);		
	}

	@Override
	protected boolean updateRecord(Employee t) {
		for(Employee employee : this.listEmployees) {
			if(employee.getId() == t.getId()) {
				if(t.getId() != 0) {
					employee.setId(t.getId());
				}
				if(t.getEmail() != null) {
					employee.setEmail(t.getEmail());
				}
				if(t.getPhoneNumber() != null) {
					employee.setPhoneNumber(t.getPhoneNumber());
				}
				return true;
			}
		}
		return false;
}

	@Override
	protected Employee createInstance() {
		
		String idEmployeeString = JOptionPane.showInputDialog(
	            null,
	            "Digite el número de identificación del empleado : ",
	            "Agregar registro de empleado",
	            JOptionPane.INFORMATION_MESSAGE );

		int idEmployee = Integer.parseInt(idEmployeeString);

		String nameEmployee = JOptionPane.showInputDialog(
	            null, 
	            "Digite el nombre del empleado : ", 
	            "Agregar registro de empleado", 
	            JOptionPane.INFORMATION_MESSAGE );
		
		String phoneNumberEmployee = JOptionPane.showInputDialog(
	            null, 
	            "Digite el numero de telefono del empleado : ", 
	            "Agregar registro de empleado", 
	            JOptionPane.INFORMATION_MESSAGE );
		
		String emailEmployee = JOptionPane.showInputDialog(
	            null, 
	            "Digite el email del empleado : ", 
	            "Agregar registro de empleado", 
	            JOptionPane.INFORMATION_MESSAGE );
	
		String dniEmployee = JOptionPane.showInputDialog(
	            null, 
	            "Digite el dni del empleado : ", 
	            "Agregar registro de empleado", 
	            JOptionPane.INFORMATION_MESSAGE );
		
		/* Fechas */
		JDateChooser dateChooserBirth = new JDateChooser();
		int optionBirth = JOptionPane.showConfirmDialog(
			    null,
			    dateChooserBirth,
			    "Seleccione una fecha de nacimiento",
			    JOptionPane.OK_CANCEL_OPTION
			);
		
		Date birthdate = null;
		if (optionBirth == JOptionPane.OK_OPTION) {
		    birthdate = dateChooserBirth.getDate();
		    System.out.println(birthdate);
		}
		
		JDateChooser dateChooserHire = new JDateChooser();
		int optionHire = JOptionPane.showConfirmDialog(
			    null,
			    dateChooserHire,
			    "Seleccione una fecha de ingreso",
			    JOptionPane.OK_CANCEL_OPTION
			);
		
		Date hireDate = null;
		if (optionHire == JOptionPane.OK_OPTION) {
		    hireDate = dateChooserHire.getDate();
		    System.out.println(hireDate);
		}
		
		EmployeeTypeEnum employeeType = null;
		
		String optionEmployeeTypeString = JOptionPane.showInputDialog(
	            null,
	            "Ingrese el tipo de empleado" + "\n" + "1. Botones" + "\n" + "2. Chofer",
	            "Agregar registro de habitacion",
	            JOptionPane.INFORMATION_MESSAGE );
		
		int optionEmployeeType = Integer.parseInt(optionEmployeeTypeString);
		
		if (optionEmployeeType < 1 || optionEmployeeType > 2) {
			JOptionPane.showMessageDialog(null, "Valor invalido, el registro no se completo");
			return null;
		}if (optionEmployeeType == 1) {
			employeeType = EmployeeTypeEnum.BELLBOY;
		}if (optionEmployeeType == 2) {
			employeeType = EmployeeTypeEnum.DRIVER;
		}
		
		return new Employee(idEmployee, nameEmployee, birthdate, phoneNumberEmployee, emailEmployee, dniEmployee, hireDate, employeeType);
	}

	@Override
	protected boolean deleteRecord(int id) {
		return this.listEmployees.removeIf(room -> room.getId() == id);
	}

	
}
