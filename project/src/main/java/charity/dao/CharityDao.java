package charity.dao;

import charity.dao.InitializeDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import charity.domain.Charity;
import user.domain.User;

/**
 * DDL functions performed in database
 */
public class CharityDao {
	public static Charity findByID(String userID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Charity Charity = new Charity();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
			
		    String sql = "select * from Charity where charity_id=?";
		    PreparedStatement preparelocationment = connect.prepareStatement(sql); 
		    preparelocationment.setString(1,userID);
		    ResultSet resultSet = preparelocationment.executeQuery();
		    //ResultSet resultSet  = preparelocationment.executeUpdate();
		    System.out.println("SQL find query for " + userID + " executed ");
		    
		    while(resultSet.next()){
		    	String user_name = resultSet.getString("charity_id");
		    	if(user_name.equals(userID)){
		    		Charity.setcharity_id(resultSet.getString("charity_id"));
		    		Charity.setcharity_name(resultSet.getString("charity_name"));
		    		Charity.setcharity_location(resultSet.getString("charity_location"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		System.out.println("Retrieved" + Charity);
		return Charity;
	}	
	
	/**
	 * insert Charity
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Charity form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("We are here");
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
			System.out.println(form);

			String sql = "insert into Charity values(?,?,?)";
			PreparedStatement preparelocationment = connect.prepareStatement(sql);
		    preparelocationment.setString(1,form.getcharity_id());
		    preparelocationment.setString(2,form.getcharity_name());
		    preparelocationment.setString(3,form.getcharity_location());
		    preparelocationment.executeUpdate();
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
			String sql = "select * from Charity";
			PreparedStatement preparelocationment = connect.prepareStatement(sql); 
			ResultSet resultSet = preparelocationment.executeQuery();			
			while(resultSet.next()){
				Charity charity  = new Charity();
				charity.setcharity_id(resultSet.getString("charity_id"));
				charity.setcharity_name(resultSet.getString("charity_name"));
				charity.setcharity_location(resultSet.getString("charity_location"));
	    		list.add(charity);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> queryAggregate() throws InstantiationException, IllegalAccessException, ClassNotFoundException{ 
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
			String sql = "select * from Charity where charity_name REGEXP ' The|The ';";
			PreparedStatement preparelocationment = connect.prepareStatement(sql); 
			ResultSet resultSet = preparelocationment.executeQuery();			
			while(resultSet.next()){
				Charity charity  = new Charity();
				charity.setcharity_id(resultSet.getString("charity_id"));
				charity.setcharity_name(resultSet.getString("charity_name"));
				charity.setcharity_location(resultSet.getString("charity_location"));
	    		list.add(charity);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> queryComplex() throws InstantiationException, IllegalAccessException, ClassNotFoundException{ 
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
			String sql = "select * from charity\r\n"
					+ "where exists\r\n"
					+ "(\r\n"
					+ "    select * from location\r\n"
					+ "    where charity.charity_location = location.location_id\r\n"
					+ "    and location_state = \"CA\"\r\n"
					+ ");\r\n"
					+ "";
			PreparedStatement preparelocationment = connect.prepareStatement(sql); 
			ResultSet resultSet = preparelocationment.executeQuery();			
			while(resultSet.next()){
				Charity charity  = new Charity();
				charity.setcharity_id(resultSet.getString("charity_id"));
				charity.setcharity_name(resultSet.getString("charity_name"));
				charity.setcharity_location(resultSet.getString("charity_location"));
	    		list.add(charity);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}

	public void update(Charity form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Now going to update");
		System.out.println(form);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store_inventory","root", "password");
			String sql = "UPDATE Charity SET charity_name = ?, charity_location = ? where charity_id = ?;";
			System.out.println("Update Prepaered");
			PreparedStatement preparelocationment = connect.prepareStatement(sql); 
		    preparelocationment.setInt(3,Integer.parseInt(form.getcharity_id()));
		    preparelocationment.setString(1,form.getcharity_name());
		    preparelocationment.setString(2,form.getcharity_location());

			System.out.println(preparelocationment);

		    preparelocationment.executeUpdate();
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
			
			String sql = "delete from Charity where charity_id = ?";
			System.out.println(username);
			System.out.println("Delete Executed");
			PreparedStatement preparelocationment = connect.prepareStatement(sql); 
		    preparelocationment.setString(1,username);
		    preparelocationment.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	

	
}
