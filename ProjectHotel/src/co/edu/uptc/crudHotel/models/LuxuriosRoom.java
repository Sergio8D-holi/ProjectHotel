package co.edu.uptc.crudHotel.models;

import co.edu.uptc.crudHotel.enums.BedTypeLuxEnum;

public class LuxuriosRoom extends Room{
	private Driver driverService;
	private BedTypeLuxEnum bedType;
	
	public LuxuriosRoom(int numberBeds, boolean isAvailable, float pricePerNight, Bellboy bellboyService,
			float extraCost, Driver driverService, BedTypeLuxEnum bedType) {
		super(numberBeds, isAvailable, pricePerNight, bellboyService, extraCost);
		this.driverService = driverService;
		this.bedType = bedType;
	}
}
