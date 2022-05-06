package entity2.domain;

import java.sql.Date;

public class Store {
	/*
	 * Correspond to the user table
	 */
	
	
	private String store_number;
	private String store_inventory;
	private String store_donation_date;
	private String store_location;

	
	

	@Override
	public String toString() {
		return "[id=" + store_number + ", sku="
				+ store_inventory + ", amount=" + 
				", expirationdate= "+ store_donation_date +
				", aisle="+ store_location + "]";
	}

	public String getStoreID() {
		return store_number;
	}



	public String getStore_inventory() {
		return store_inventory;
	}

	public void setStore_inventory(String store_inventory_add) {
		store_inventory = store_inventory_add;
	}

	public String getItem_Expiration_Date() {
		return store_donation_date;
	}

	public void setItem_Expiration_Date(String item_Expiration_Date) {
		store_donation_date = item_Expiration_Date;
	}



	public void setStore_location(String store_location) {
		this.store_location = store_location;
	}

	public void setStoreID(String string) {
		store_number = string;
		
	}

	public String getStore_location() {
		return store_location;
	}

}
