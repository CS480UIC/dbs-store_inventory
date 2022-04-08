-- Minimum N simple queries. 
-- A simple query searches data in one table using logic operators in the condition, and orders the result by a particular column.

SELECT * from inventory
where item_expiration_date = '2022-04-21'
order by inventory_id asc;

SELECT * from donation_items
where donation_amount = 4
order by donation_store;

-- Minimum N aggregate queries or queries with functions. 
-- An aggregate query groups data in one table and applies an aggregate function

--  From the N queries, at least one should use a numeric function.
--  From the N queries, at least one should use a string function.
--  From the N queries, at least one should use a date and time function.
--  From the N queries, at least one should group rows with identical values into a set of summary rows and filter group results (GROUP BY and HAVING clauses).


select item_expiration_date from inventory
order by abs(now() - date) desc;

select  * from inventory
order by MAX(VAL(inventory.item_amount)) asc;

select * from charity
where charity_name LIKE '%The%';

select donation_store from donation_items
group by donation_store having COUNT(donation_store) > 1;


-- Minimum N complex queries.
-- A complex query searches data in two or more tables.
--  From the N queries, at least one should use a join (any type of join).
--  From the N queries, at least one should use a correlated subquery (without EXIST).
--  From the N queries, at least one should use a correlated subquery that uses the EXIST clause

SELECT store.store_donation_date, store.store_number, donation_items.donation_sku
FROM store
INNER JOIN donation_items on donation_items.donation_date=store.store_donation_date;

SELECT * FROM donation_items
  WHERE donation_charity = ANY (SELECT charity_id FROM charity
                       WHERE donation_items.donation_charity = charity.charity_id)

select charity_id, charity_name from charity
where exists
(
    select * from location
    where charity.charity_location = location.location_id
    and location_state = "CA"
);

