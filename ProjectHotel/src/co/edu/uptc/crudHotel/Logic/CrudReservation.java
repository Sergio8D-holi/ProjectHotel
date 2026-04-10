package co.edu.uptc.crudHotel.Logic;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import co.edu.uptc.crudHotel.models.Customer;
import co.edu.uptc.crudHotel.models.Room;
import co.edu.uptc.crudHotel.models.Reservation;
import co.edu.uptc.crudHotel.Logic.CrudEmployee;
import co.edu.uptc.crudHotel.enums.EmployeeTypeEnum;
import co.edu.uptc.crudHotel.Logic.CrudCustomer;

public class CrudReservation extends AbstractCrud<Reservation>{
	private List<Reservation> listReservation;
	private CrudCustomer crudCustomer;
	private CrudEconomicRoom crudEconomicRoom;
	private CrudLuxuriousRoom crudLuxuriousRoom; 

	public CrudReservation(String nameEntity, List<Reservation> listReservation, CrudCustomer crudCustomer,
			CrudEconomicRoom crudEconomicRoom, CrudLuxuriousRoom crudLuxuriousRoom) {
		super(nameEntity);
		this.listReservation = listReservation;
		this.crudCustomer = crudCustomer;
		this.crudEconomicRoom = crudEconomicRoom;
		this.crudLuxuriousRoom = crudLuxuriousRoom;
	}

	@Override
	protected boolean newRecord(Reservation record) {
		if(this.findRecordById(record.getId()) == null) {
			this.listReservation.add(record);
			return true;
		}
		return false;
	}

	@Override
	protected Reservation findRecordById(int id) {
		return this.listReservation.stream().filter(s -> s.getId() == id)
				.findAny().orElse(null);
	}

	@Override
	protected boolean updateRecord(Reservation t) {
		for(Reservation reservation: this.listReservation) {
			if(reservation.getId() == t.getId()) {
				if(t.getId() != 0) {
					reservation.setId(t.getId());
				}
				if(t.getCustomer() != null) {
					reservation.setCustomer(t.getCustomer());
				}
				if(t.getReservedDays() != 0) {
					reservation.setReservedDays(t.getReservedDays());
				}
				if (t.getRoom() != null) {
					reservation.setRoom(t.getRoom());
				}
				return true;
			}
		}
		return false;
	}
	
	@Override
	protected Reservation createInstance() {
		String idReservationString = JOptionPane.showInputDialog(
	            null,
	            "Digite el número de identificación de la reserva : ",
	            "Agregar registro de reserva ",
	            JOptionPane.INFORMATION_MESSAGE );

		int idReservation = Integer.parseInt(idReservationString);
		
		/* Fechas */
		JDateChooser dateChooserArrival = new JDateChooser();
		int optionArrival = JOptionPane.showConfirmDialog(
			    null,
			    dateChooserArrival,
			    "Seleccione una fecha de llegada",
			    JOptionPane.OK_CANCEL_OPTION
			);
		
		Date arrivalDate = null;
		if (optionArrival == JOptionPane.OK_OPTION) {
		    arrivalDate = dateChooserArrival.getDate();
		    System.out.println(arrivalDate);
		}
		
		String reservedDaysString = JOptionPane.showInputDialog(
	            null,
	            "Digite el número de dias reservados: ",
	            "Agregar registro de reserva",
	            JOptionPane.INFORMATION_MESSAGE );

		int reservedDays = Integer.parseInt(reservedDaysString);
		
		// Cliente
		String idCustomerString = JOptionPane.showInputDialog(
		        null,
		        "Digite el ID del cliente: ",
		        "Agregar registro de reserva",
		        JOptionPane.INFORMATION_MESSAGE
		);

		int idCustomer = Integer.parseInt(idCustomerString);

		Customer customer = null;
        for (Customer c : crudCustomer.getListCustomers()) {
            if (c.getId() == idCustomer) {
                customer = c;
                break;
            }
        }

		if (customer == null) {
		    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
		    return null;
		}

		String optionRoomTypeString = JOptionPane.showInputDialog(
	            null,
	            "Ingrese el tipo de habitacion" + "\n" + "1. Economica" + "\n" + "2. Lujosa",
	            JOptionPane.INFORMATION_MESSAGE );
		
		int optionRoomType = Integer.parseInt(optionRoomTypeString);
		
		if (optionRoomType < 1 || optionRoomType > 2) {
			JOptionPane.showMessageDialog(null, "Valor invalido, el registro no se completo");
			return null;
		}if (optionRoomType == 1) {
			String idRoomString = JOptionPane.showInputDialog(
			        null,
			        "Digite el ID de la habitacion: ",
			        "Agregar registro de reserva",
			        JOptionPane.INFORMATION_MESSAGE
			);

			int idRoom = Integer.parseInt(idRoomString);

			Room room = null;
	        for (Room r : crudEconomicRoom.getListRooms()) {
	            if (r.getId() == idRoom) {
	                room = r;
	                break;
	            }
	        }

			if (room == null) {
			    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
			    return null;
			}
		}if (optionRoomType == 2) {
		}String idRoomString = JOptionPane.showInputDialog(
		        null,
		        "Digite el ID de la habitacion: ",
		        "Agregar registro de reserva",
		        JOptionPane.INFORMATION_MESSAGE
		);

		int idRoom = Integer.parseInt(idRoomString);

		Room room = null;
        for (Room r : crudLuxuriousRoom.getListLuxRooms()) {
            if (r.getId() == idRoom) {
                room = r;
                break;
            }
        }

		if (room == null) {
		    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
		    return null;
		}

		
		return new Reservation(idReservation, room, customer, arrivalDate, reservedDays);
	}

	@Override
	protected boolean deleteRecord(int id) {
		return this.listReservation.removeIf(room -> room.getId() == id);
	}
	
	

}
