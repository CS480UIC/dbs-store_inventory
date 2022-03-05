<h1> Entity </h1>
  
  Entity Name: store
  > Synonyms: resturaunt, supermarket, gas station 
 
  > Description: A location in which pershable items are sold

  Entity Name: inventory
  > Synonyms: Stock 
 
  > Description: A list of items present at each store

  Entity Name: donation_items
  > Synonyms: None

  > Description: items that have been marked for donation

<h1> Relationship </h1>

  Relationship: inventory-in-store:
  > Minima: zero-zero

  > Maxima: one-one
 
 
  Relationship: items-in-donation:
  > Minima: zero-zero

  > Maxima: many-one
  
  Relationship: donation-piles-in-store:
  > Minima: zero-one

  > Maxima: many-one
 
 <h1> Attributes </h1>
 
  Table Name: inventory
  > Attribute: inventory_id 1-1(1) (PK UNIQUE AUTOINCREMENT NOT NULL INT)
  
  > Attribute: item_sku M-1(1) (UNIQUE NOT NULL INT)
  
  > Attribute: item_expiration_date  M-M(1) (NOT NULL DATETIME)
  
  > Attribute: item_aisle M-M (0) (NOT NULL VARCHAR)
  
  > Attribute: item_amount M-M (0) (INT)

  Table Name: store
  > Attribute: store_number 1-1(1) (PK UNIQUE NOT NULL INT)
  
  > Attribute: store_inventory 1-1(1) (NOT NULL INT)
  
  > Attribute: store_donation_date 1-1 (1) (NOT NULL DATETIME)

  Table Name: donation_items
  > Attribute: donation_store 1-1(1) (PK UNIQUE NOT NULL INT)
  
  > Attribute: donation_sku M-1(1) (UNIQUE NOT NULL INT)
  
  > Attribute: donation_date M-1(1) (NOT NULL INT)
  
  > Attribute: donation_amount M-M (0) (NOT NULL DATETIME)
  
