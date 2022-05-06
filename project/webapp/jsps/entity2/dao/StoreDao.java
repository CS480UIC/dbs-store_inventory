package entity2.dao;
import entity2.dao.InitializeDao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import entity2.domain.Store;


/**
 * DDL functions performed in database
 */
public class StoreDao {
	/**
	 * insert store
	 * 
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Store form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("We are her forme");
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
			
			String sql = "insert into store values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			System.out.println(form.getStoreID());
			System.out.println(form.getStore_inventory());
			System.out.println(form.getItem_Expiration_Date());
			System.out.println(form.getStore_location());

		    preparestatement.setString(1,form.getStoreID());
		    preparestatement.setString(2,form.getStore_inventory());
		    preparestatement.setString(3,form.getItem_Expiration_Date());
		    preparestatement.setString(4,form.getStore_location());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{ 
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
			String sql = "select * from store";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Store storeEntity  = new Store();
				storeEntity.setStoreID(resultSet.getString("store_number"));
	    		storeEntity.setStore_inventory(resultSet.getString("store_inventory"));
	    		storeEntity.setItem_Expiration_Date(resultSet.getString("item_expiration_date"));
	    		storeEntity.setStore_location(resultSet.getString("store_location"));
	    		list.add(storeEntity);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}

	public void update(Store form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Now going to update");
		System.out.println(form);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
			String sql = "UPDATE store SET store_inventory = ?, store_donation_date = ? , store_location = ? where store_number = ?;";
			System.out.println("Update Prepaered");
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(4,form.getStoreID());
		    preparestatement.setString(1,form.getStore_inventory());
		    preparestatement.setString(2,form.getItem_Expiration_Date());
		    preparestatement.setString(3,form.getStore_location());
			System.out.println(preparestatement);
		    preparestatement.executeUpdate();
			System.out.println("Update Executed");

		    connect.close();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void delete(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Now going to delete");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
			
			String sql = "delete from store where store_number = ?";
			System.out.println(username);
			System.out.println("Delete Executed");
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,username);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Store findByID(String string) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Store store = new Store();
		System.out.println("Searching");
		System.out.println(string);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
		    String sql = "select * from store_inventory.store where store_number=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,string);
		    ResultSet resultSet = preparestatement.executeQuery();
		    System.out.println("res");
		    while(resultSet.next()){
		    	System.out.println(resultSet.getString("store_number"));
		    	String user_name = resultSet.getString("store_number");
		    	if(user_name.equals(string)){
		    		store.setStoreID(resultSet.getString("store_number"));
		    		store.setStore_inventory(resultSet.getString("store_inventory"));
		    		store.setItem_Expiration_Date(resultSet.getString("store_donation_date"));
		    		store.setStore_location(resultSet.getString("store_location"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Retrieved" + store);
		return store;
	}	
	

	
	

	
}
