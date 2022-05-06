package location.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Location {
	/*
	 * Correspond to the user table
	 */
	
	
	private String location_id;
	private String location_city;
	private String location_state;


//	@Override
//	public String toString() {
//		return "[id=" + location_id + ", sku="
//				+ location_city + ", amount=" + Item_Amount +
//				", expirationdate= "+ location_state +
//				", aisle="+ Item_Aisle + "]";
//	}

	public String getlocation_id() {
		return location_id;
	}

	public void setlocation_id(String location_id) {
		this.location_id = location_id;
	}

	public String getlocation_city() {
		return location_city;
	}

	public void setlocation_city(String location_city) {
		this.location_city = location_city;
	}

	public String getlocation_state() {
		return location_state;
	}

	public void setlocation_state(String location_state) {
		this.location_state = location_state;
	}

}
