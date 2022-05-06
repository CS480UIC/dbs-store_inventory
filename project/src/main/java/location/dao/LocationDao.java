package location.dao;

import location.dao.InitializeDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import location.domain.Location;
import user.domain.User;

/**
 * DDL functions performed in database
 */
public class LocationDao {
	public static Location findByID(String userID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Location Location = new Location();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
			
		    String sql = "select * from Location where location_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,userID);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    System.out.println("SQL find query for " + userID + " executed ");
		    
		    while(resultSet.next()){
		    	String user_name = resultSet.getString("location_id");
		    	if(user_name.equals(userID)){
		    		Location.setlocation_id(resultSet.getString("location_id"));
		    		Location.setlocation_city(resultSet.getString("location_city"));
		    		Location.setlocation_state(resultSet.getString("location_state"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		System.out.println("Retrieved" + Location);
		return Location;
	}	
	
	/**
	 * insert Location
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Location form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("We are here");
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
			System.out.println(form);

			String sql = "insert into Location values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
		    preparestatement.setString(1,form.getlocation_id());
		    preparestatement.setString(2,form.getlocation_city());
		    preparestatement.setString(3,form.getlocation_state());
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
			String sql = "select * from Location";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Location location  = new Location();
				location.setlocation_id(resultSet.getString("location_id"));
				location.setlocation_city(resultSet.getString("location_city"));
				location.setlocation_state(resultSet.getString("location_state"));
	    		list.add(location);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> querySimple() throws InstantiationException, IllegalAccessException, ClassNotFoundException{ 
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
			String sql = "SELECT * from location\r\n"
					+ "where (location_state = 'CA')\r\n"
					+ "order by location_city asc;\r\n"
					;
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Location location  = new Location();
				location.setlocation_id(resultSet.getString("location_id"));
				location.setlocation_city(resultSet.getString("location_city"));
				location.setlocation_state(resultSet.getString("location_state"));
	    		list.add(location);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}


	public void update(Location form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Now going to update");
		System.out.println(form);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
			String sql = "UPDATE Location SET location_city = ?, location_state = ? where location_id = ?;";
			System.out.println("Update Prepaered");
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(3,Integer.parseInt(form.getlocation_id()));
		    preparestatement.setString(1,form.getlocation_city());
		    preparestatement.setString(2,form.getlocation_state());

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
			
			String sql = "delete from Location where location_id = ?";
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
