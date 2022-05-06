package charity.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity1.domain.Entity1;
import user.domain.User;



/**
 * DDL functions performed in database
 */
public class InitializeDao {
	
	/**
	 * get the Search result with Username 
	 * @throws ClassNotFoundException 
	 */
	public void initDB() throws ClassNotFoundException {
		try {
			System.out.println("attempting");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
	          String sql = "CREATE TABLE entity1 " +
	                   "(Inventory_ID smallint NOT NULL, " + 
	                   " Item_SKU int NOT NULL, " + 
	                   " Item_Expiration_Date datetime NOT NULL" +
	                   " Item_Amount int DEFAULT NULL) ";
	          
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.executeQuery();
		    connect.close();
	         System.out.println("Created table in given database...");   	  
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

	
	
	/**
	 * insert User
	 */
	public void add(Entity1 form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("We are here");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
			
			String sql = "insert into entity1 values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
		    preparestatement.setString(1,form.getInventory_ID());
		    preparestatement.setString(2,form.getItem_SKU());
		    preparestatement.setString(3,form.getItem_Expiration_Date());
		    preparestatement.setString(4,form.getItem_Aisle());
		    preparestatement.setString(5,form.getItem_Amount());
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
			String sql = "select * from user";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				User user = new User();
				user.setUsername(resultSet.getString("username"));
	    		user.setPassword(resultSet.getString("password"));
	    		user.setEmail(resultSet.getString("email"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
		
}
