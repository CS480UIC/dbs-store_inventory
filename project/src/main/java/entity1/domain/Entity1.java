package entity1.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Entity1 {
	/*
	 * Correspond to the user table
	 */
	
	
	private String Inventory_ID;
	private String Item_SKU;
	private String Item_Expiration_Date;
	private String Item_Aisle;
	private String Item_Amount;

	
	

	@Override
	public String toString() {
		return "[id=" + Inventory_ID + ", sku="
				+ Item_SKU + ", amount=" + Item_Amount +
				", expirationdate= "+ Item_Expiration_Date +
				", aisle="+ Item_Aisle + "]";
	}

	public String getInventory_ID() {
		return Inventory_ID;
	}

	public void setInventory_ID(String inventory_ID) {
		Inventory_ID = inventory_ID;
	}

	public String getItem_SKU() {
		return Item_SKU;
	}

	public void setItem_SKU(String item_SKU) {
		Item_SKU = item_SKU;
	}

	public String getItem_Expiration_Date() {
		return Item_Expiration_Date;
	}

	public void setItem_Expiration_Date(String item_Expiration_Date) {
		Item_Expiration_Date = item_Expiration_Date;
	}

	public String getItem_Aisle() {
		return Item_Aisle;
	}

	public void setItem_Aisle(String item_Aisle) {
		Item_Aisle = item_Aisle;
	}

	public String getItem_Amount() {
		return Item_Amount;
	}

	public void setItem_Amount(String item_Amount) {
		Item_Amount = item_Amount;
	}
}
