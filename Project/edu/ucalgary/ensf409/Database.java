package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.*;

/**
 * Program version 20.0
 * @author Alexander Sembrat, Dylan Windsor, Matthew Ho. Group 36.
 * 
 * This class interacts with the database, pulling data and deleting it from the database when needed.
 */
public class Database {

	public String USERNAME;
	public String PASSWORD;
	public String DBURL;
	
	private Connection dbConnect;
	
	/**
	 * Constructor for Database
	 * @param DBURL will be the database url that will be used.
	 * @param USERNAME The username of the database login.
	 * @param PASSWORD The password of the database login.
	 */
	Database(String DBURL, String USERNAME, String PASSWORD){
		this.USERNAME = USERNAME;
		this.PASSWORD = PASSWORD;
		this.DBURL = DBURL;
	}
	
	/**
	 * This method initializes the connection with the inventory database using DBURL, USERNAME, and PASSWORD
	 */
	public void initializeConnection() {
		try {
    		dbConnect = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}	
	}
	
	/**
	 * This method accesses and copies requested chair data from inventory. 
	 * @param type is the type of chair you wish to request. 	
	 * @return An ArrayList<Chair> will be returned that contains all chairs of type in inventory.
	 */
	public ArrayList<Chair> getChairs(String type){
		
		ArrayList<Chair> chairs = new ArrayList<Chair>();		//the list of chairs to be returned
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "chair"); //selects all data from the table chair
    		
    		while(result.next()) {	
    			if(result.getString("Type").equals(type)) {	//selects only the type of chair requested
    				//System.out.println("Into add chairs");
    				Chair temp = new Chair(result.getString("ID"),result.getString("Type"),result.getString("Legs").charAt(0)
    						,result.getString("Arms").charAt(0),result.getString("Seat").charAt(0),
    						result.getString("Cushion").charAt(0),result.getInt("Price"),result.getString("ManuID"));
    				chairs.add(temp);	//adds the new chair to the list
    			}
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return chairs;
	}
	
	/**
	 * This method accesses and copies requested desk data from inventory. 
	 * @param type is the type of desk you wish to request. 	
	 * @return An ArrayList<Desk> will be returned that contains all desks of type in inventory.
	 */
	public ArrayList<Desk> getDesks(String type){
		
		ArrayList<Desk> desks = new ArrayList<Desk>(); //the list of desks to be returned
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "desk"); //selects all data from the table desk
    		
    		while(result.next()) {
    			if(result.getString("Type").equals(type)) {
    				Desk temp = new Desk(result.getString("ID"),result.getString("Type"),result.getString("Legs").charAt(0)
    						,result.getString("Top").charAt(0),result.getString("Drawer").charAt(0),
    						result.getInt("Price"),result.getString("ManuID"));
    				desks.add(temp);	//adds the new desk to the list
    				}
    			}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
		return desks;
	}
	
	/**
	 * This method accesses and copies requested filing data from inventory. 
	 * @param type is the type of filing you wish to request. 	
	 * @return An ArrayList<Filing> will be returned that contains all filing of type in inventory.
	 */
	public ArrayList<Filing> getFilings(String type){
		
		ArrayList<Filing> filings = new ArrayList<Filing>(); //the list of filings to be returned
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "filing"); //selects all the data from table filing
    		
    		while(result.next()) {
    			if(result.getString("Type").equals(type)) {
    				Filing temp = new Filing(result.getString("ID"),result.getString("Type"),result.getString("Rails").charAt(0)
    						,result.getString("Drawers").charAt(0),result.getString("Cabinet").charAt(0),result.getInt("Price")
    						,result.getString("ManuID"));
    				filings.add(temp);	//adds the new filing to the list
    				}
    			}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
		return filings;
	}
	
	/**
	 * This method accesses and copies requested lamp data from inventory. 
	 * @param type is the type of lamp you wish to request. 	
	 * @return An ArrayList<Lamp> will be returned that contains all lamps of type in inventory.
	 */
	public ArrayList<Lamp> getLamps(String type){
		
		ArrayList<Lamp> lamps = new ArrayList<Lamp>(); //the list of lamps to be returned.
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "lamp"); //selects all the data from table lamp
    		
    		while(result.next()) {
    			if(result.getString("Type").equals(type)) {
    				Lamp temp = new Lamp(result.getString("ID"),result.getString("Type"),result.getString("Base").charAt(0),result.getString("Bulb").charAt(0),result.getInt("Price"),result.getString("ManuID"));
    				lamps.add(temp); //adds the new lamp to the list
    				}
    			}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
		return lamps;
	}
	
	/**
	 * This method accesses and copies all manufacturers. 	
	 * @return An ArrayList<Manufacturer> that contains all manufactures in inventory.
	 */
	public ArrayList<Manufacturer> getManufacturers(){
		
		ArrayList<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "manufacturer");
    		
    		while(result.next()) {
    			
    		Manufacturer temp = new Manufacturer(result.getString("ManuID"),result.getString("Name"),result.getString("Phone"),result.getString("Province"));
    		manufacturers.add(temp);
    		}
    			
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
		return manufacturers;
	}
	
	/**
	 * This method deletes a chair with the parameter id from the database.
	 * @param id the unique identifier that is used to delete the chair from the database.
	 */
	public void deleteChair(String id) {
		try {
    		String query = "DELETE FROM chair WHERE ID = ?";
    		PreparedStatement state = dbConnect.prepareStatement(query);
    		
    		state.setString(1,id);
    		
    		state.executeUpdate();
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
	}
	
	/**
	 * This method deletes a desk with the parameter id from the database.
	 * @param id the unique identifier that is used to delete the desk from the database.
	 */
	public void deleteDesk(String id) {
		try {
    		String query = "DELETE FROM desk WHERE ID = ?";
    		PreparedStatement state = dbConnect.prepareStatement(query);
    		
    		state.setString(1,id);
    		
    		state.executeUpdate();
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
	}
	
	/**
	 * This method deletes a filing with the parameter id from the database.
	 * @param id the unique identifier that is used to delete the filing from the database.
	 */
	public void deleteFiling(String id) {
		try {
    		String query = "DELETE FROM filing WHERE ID = ?";
    		PreparedStatement state = dbConnect.prepareStatement(query);
    		
    		state.setString(1,id);
    		
    		state.executeUpdate();
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
	}
	
	/**
	 * This method deletes a desk with the parameter id from the database.
	 * @param id the unique identifier that is used to delete the chair from the database.
	 */
	public void deleteLamp(String id) {
		try {
    		String query = "DELETE FROM lamp WHERE ID = ?";
    		PreparedStatement state = dbConnect.prepareStatement(query);
    		
    		state.setString(1,id);
    		
    		state.executeUpdate();
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
	}
	
	/**
	 * This method returns the id's of all the manufacturers that make chairs.
	 * @return an ArrayList<String> of each manufactures id.
	 */
	public ArrayList<String> getChairManufacturers(){
		
		ArrayList<String> manuIDs = new ArrayList<String>();	//list of manuID's
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "chair");
    		
    		while(result.next()) {
    			String manu = result.getString("ManuID");
    			if(manuIDs.contains(manu)==false) {		//selects only data with the lab ManuID
    				manuIDs.add(manu);					//adds the manuID to the list.
    			}
    			
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return manuIDs;
	}
	
	/**
	 * This method returns the id's of all the manufacturers that make desks.
	 * @return an ArrayList<String> of each manufactures id.
	 */
	public ArrayList<String> getDeskManufacturers(){
		
		ArrayList<String> manuIDs = new ArrayList<String>();	//list of manuID's
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "desk");
    		
    		while(result.next()) {
    			String manu = result.getString("ManuID"); 
    			if(manuIDs.contains(manu)==false) { 	//selects only data with the lab ManuID
    				manuIDs.add(manu);					//adds the manuID to the list.
    			}
    			
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return manuIDs;
	}
	
	/**
	 * This method returns the id's of all the manufacturers that make filings.
	 * @return an ArrayList<String> of each manufactures id.
	 */
	public ArrayList<String> getFilingManufacturers(){
		
		ArrayList<String> manuIDs = new ArrayList<String>(); //list of manuID's
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "filing");
    		
    		while(result.next()) {
    			String manu = result.getString("ManuID");
    			if(manuIDs.contains(manu)==false) { //selects only data with the lab ManuID
    				manuIDs.add(manu);				//adds the manuID to the list.
    			}
    			
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return manuIDs;
	}
	
	/**
	 * This method returns the id's of all the manufacturers that make lamps.
	 * @return an ArrayList<String> of each manufactures id.
	 */
	public ArrayList<String> getLampManufacturers(){
		
		ArrayList<String> manuIDs = new ArrayList<String>(); //list of manuID's
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "lamp");
    		
    		while(result.next()) {
    			String manu = result.getString("ManuID");
    			if(manuIDs.contains(manu)==false) {		//selects only data with the lab ManuID
    				manuIDs.add(manu);					//adds the manuID to the list.
    			}
    			
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return manuIDs;
	}

}
