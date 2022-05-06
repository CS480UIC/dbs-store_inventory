package entity1.dao;

import entity1.dao.InitializeDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import entity1.domain.Entity1;
import user.domain.User;

/**
 * DDL functions performed in database
 */
public class Entity1Dao {
	public static Entity1 findByID(String userID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Entity1 entity1 = new Entity1();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
		    String sql = "select * from entity1 where Inventory_ID=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,userID);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	String user_name = resultSet.getString("Inventory_ID");
		    	if(user_name.equals(userID)){
		    		entity1.setInventory_ID(resultSet.getString("Inventory_ID"));
		    		entity1.setItem_SKU(resultSet.getString("Item_SKU"));
		    		entity1.setItem_Amount(resultSet.getString("Item_Amount"));
		    		entity1.setItem_Expiration_Date(resultSet.getString("Item_Expiration_Date"));
		    		entity1.setItem_Aisle(resultSet.getString("Item_Aisle"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Retrieved" + entity1);
		return entity1;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Entity1 form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("We are here");
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
			
			String sql = "insert into entity1 values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			System.out.println(form);
		    preparestatement.setString(1,form.getInventory_ID());
		    preparestatement.setString(2,form.getItem_SKU());
		    preparestatement.setString(3,form.getItem_Expiration_Date());
		    preparestatement.setString(5,form.getItem_Aisle());
		    preparestatement.setString(4,form.getItem_Amount());
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
			String sql = "select * from entity1";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Entity1 entit1  = new Entity1();
				entit1.setInventory_ID(resultSet.getString("Inventory_ID"));
				entit1.setItem_SKU(resultSet.getString("Item_SKU"));
				entit1.setItem_Amount(resultSet.getString("Item_Amount"));
				entit1.setItem_Expiration_Date(resultSet.getString("Item_Expiration_Date"));
				entit1.setItem_Aisle(resultSet.getString("Item_Aisle"));
	    		list.add(entit1);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}

	public void update(Entity1 form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Now going to update");
		System.out.println(form);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
			String sql = "UPDATE entity1 SET Item_SKU = ?, Item_Expiration_Date = ? , Item_Aisle = ? , Item_Amount = ?  where Inventory_ID = ?;";
			System.out.println("Update Prepaered");
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(5,Integer.parseInt(form.getInventory_ID()));
		    preparestatement.setString(1,form.getItem_SKU());
		    preparestatement.setString(2,form.getItem_Expiration_Date());
		    preparestatement.setString(3,form.getItem_Aisle());
		    preparestatement.setString(4,form.getItem_Amount());
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
			
			String sql = "delete from entity1 where Inventory_ID = ?";
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
	
	

	
}
