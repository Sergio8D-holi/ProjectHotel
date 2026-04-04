package co.edu.uptc.crudHotel.models;

import co.edu.uptc.crudHotel.enums.BedTypeEconomicEnum;

public class EconomicRoom extends Room{
	private BedTypeEconomicEnum bedType;

	public EconomicRoom(int numberBeds, boolean isAvailable, float pricePerNight, Bellboy bellboyService,
			float extraCost, BedTypeEconomicEnum bedType) {
		super(numberBeds, isAvailable, pricePerNight, bellboyService, extraCost);
		this.bedType = bedType;
	}
}
