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

<h1> Relationship </h1>

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
