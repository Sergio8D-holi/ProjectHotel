package co.edu.uptc.crudHotel.models;

import co.edu.uptc.crudHotel.enums.BedTypeLuxEnum;

public class LuxuriosRoom extends Room{
	private boolean driverService;
	private BedTypeLuxEnum bedType;

	public LuxuriosRoom(int id, int numberBeds, boolean isAvailable, float pricePerNight, boolean bellboyService,
			boolean driverService, BedTypeLuxEnum bedType) {
		super(id, numberBeds, isAvailable, pricePerNight, bellboyService);
		this.driverService = driverService;
		this.bedType = bedType;
	}

	public boolean getDriverService() {
		return driverService;
	}

	public void setDriverService(boolean driverService) {
		this.driverService = driverService;
	}

	public BedTypeLuxEnum getBedType() {
		return bedType;
	}

	public void setBedType(BedTypeLuxEnum bedType) {
		this.bedType = bedType;
	}

}
