package charity.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Charity {
	/*
	 * Correspond to the user table
	 */
	
	
	private String charity_id;
	private String charity_name;
	private String charity_location;


//	@Override
//	public String toString() {
//		return "[id=" + charity_id + ", sku="
//				+ charity_name + ", amount=" + Item_Amount +
//				", expirationdate= "+ charity_location +
//				", aisle="+ Item_Aisle + "]";
//	}

	public String getcharity_id() {
		return charity_id;
	}

	public void setcharity_id(String charity_id) {
		this.charity_id = charity_id;
	}

	public String getcharity_name() {
		return charity_name;
	}

	public void setcharity_name(String charity_name) {
		this.charity_name = charity_name;
	}

	public String getcharity_location() {
		return charity_location;
	}

	public void setcharity_location(String charity_location) {
		this.charity_location = charity_location;
	}

}
