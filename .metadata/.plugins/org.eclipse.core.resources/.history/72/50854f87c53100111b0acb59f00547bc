package co.edu.uptc.crudHotel.Logic;

import java.util.ArrayList;
import java.util.List;

public class Management <T extends BaseClass> {
private List<T> listObject;
	
	public Management() {
		this.listObject = new ArrayList<>();
	}
	
	public List<T> getListObject() {
		return listObject;
	}

	public void setListObject(List<T> listObject) {
		this.listObject = listObject;
	}

	public boolean insertObject(T object) {
		System.out.println("Ingreso");
		if(this.findObjectById(object.getNumber()) == null) {
			System.out.println("Agregó");
			this.listObject.add(object);
			return true;
		}
		
		return false;
	}
	
	public T findObjectById(String id) {
	    return this.listObject.stream()
	            .filter(t -> t.getNumber().equals(id))
	            .findAny()
	            .orElse(null);
	}
	
	public int findIndexObjectById(String id) {
		for(int i=0; i < this.listObject.size(); i++) {
			if(this.listObject.get(i).getNumber().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean updateObject(T newRecord) {
		/* Identificar el registro actual */
		T object = this.findObjectById(newRecord.getNumber());	
		if(object == null) {
			return false;
		}
		/* Actualizarlo en la lista */
		this.listObject.set(this.findIndexObjectById(newRecord.getNumber()), 
				object);
		return true;
	}
	
	public boolean deleteObject(String id) {
		int index = this.findIndexObjectById(id);
		if(index != -1) {
			this.listObject.remove(index);
			return true;
		}
		return false;	
	}
}
