<h1> Entity </h1>
  
  Entity Name: item_sku
  > Synonyms: Barcode, Serial Number, 
 
  > Description: A way to give an identity to unique items

  Entity Name: item_aisle
  > Synonyms: Alley, walkway, location, avenue 
 
  > Description: Location of item

  Entity Name: item_amount
  > Synonyms: inventory, stock 

  > Description: Amount of items in inventory
  
  Entity Name: item_expiration_date
  > Synonyms: None 

  > Description: Date of expiration

  
  Entity Name: store_donation_date
  > Synonyms: 

  > Description: The length of time before an expiration date an item should be donated. (Ex: 1 = one week before expiration date, 2 = two weeks before expiration       date)
 
 Entity Name: store_name
 > Synonyms: Store Numebr

 > Description: Name of store

<h1> Relationship </h1>

  Relationship: inventory-in-store:
  > Minima: one-one

  > Maxima: one-one

  Relationship: sku-in-aisle
  > Minima: zero-one
 
  > Maxima: many-many

  Relationship: expiration_date-on-sku
  > Minima: one-one
 
  > Maxima: one-one

  Relationship: amount-of-sku
  > Minima: zero-zero
  
  > Maxima: many-one
 
 <h1> Attributes </h1>
 
  Table Name: inventory
  > Attribute: item_sku M-1(1)
  
  > Attribute: item_expiration_date  M-M(1)
  
  > Attribute: item_aisle M-M (0)
  
  > Attribute: item_amount M-M (0)

  Table Name: store
  > Attribute: store_name 1-1(1)
  
  > Attribute: store_inventory 1-1(1)
  
  > Attribute: store_donation_date 1-1 (1)
  
