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
  > Attribute: item_sku M-1(1)
  
  > Attribute: item_expiration_date  M-M(1)
  
  > Attribute: item_aisle M-M (0)
  
  > Attribute: item_amount M-M (0)

  Table Name: store
  > Attribute: store_name 1-1(1)
  
  > Attribute: store_inventory 1-1(1)
  
  > Attribute: store_donation_date 1-1 (1)

  Table Name: donation_items
  > Attribute: donation_sku M-1(1)
  
  > Attribute: donation_date M-1(1)
  
  > Attribute: donation_amount M-M (0)
  
