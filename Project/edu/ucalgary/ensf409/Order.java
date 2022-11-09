package edu.ucalgary.ensf409;

//import static org.junit.Assert.assertThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
/**
 * Program version 20.0
 * @author Alexander Sembrat, Dylan Windsor, Matthew Ho. Group 36.
 * 
 * This is the class from which the main function will be called.
 * It will take in user input and give the user output based on the results of their order.
 */
public class Order {
	
	private String category;
	private String type;
	private int amount;
	
	/**
	 * Constructor for order. 
	 * It asks the user for input regarding their order and manipulates it to ensure it works with the database class.
	 */
	public Order(){
		Scanner scan = new Scanner(System.in);			//this scanner is used to get user input
		System.out.println("Please Enter the category of furniture you wish to order.");
		this.setCategory(scan.next().toLowerCase());	//formats the category to all lowercase
		System.out.println("Please Enter the type of " + this.category + " you wish to order.");
		this.type = scan.next().toLowerCase();			//formats the type to all lowercase
		this.type = this.type.toUpperCase().charAt(0)+this.type.substring(1,this.type.length());//formats type to start with an uppercase and have the rest be lowercase
		if(this.type.equals("Swing")) {	//Exception for if a user wants a swing arm lamp. This allows 2 arguemnts to be used for type if the first is swing.
			String temp = scan.next().toLowerCase();
			temp = temp.toUpperCase().charAt(0)+temp.substring(1,temp.length());		
			this.type = this.type.concat(" ");
			this.type = this.type.concat(temp);										//same formatting as lines 28 and 29 with a space between the tokens
		}
		System.out.println("Please Enter the amount you wish to order in the form of an integer. ");
		this.setAmount(scan.nextInt());
		if(type.equals("Ergonomic")||type.equals("Executive")||type.equals("Kneeling")||type.equals("Mesh")||type.equals("Task")) {}
		else if(type.equals("Adjustable")||type.equals("Standing")||type.equals("Traditional")) {}
		else if(type.equals("Small")||type.equals("Medium")||type.equals("Large")) {}
		else if(type.equals("Desk")||type.equals("Study")||type.equals("Swing Arm")) {}
		else {
			System.out.println("Invalid type, try again.");			//if an invalid type is entered an exception is thrown.
			scan.close();								
			throw new IllegalArgumentException();
		}
		if(amount<=0) {		//tests that the amount is an acceptable request. Throw an exception if not.
			System.out.println("Invalid amount, please enter an amount of 1 or greater.");
			scan.close();
			throw new IllegalArgumentException();
		}
		scan.close();
	}
	
	/**
	 * Constructor mainly for testing.
	 * @param category gets set to category
	 * @param type gets set to type
	 * @param amount gets set to amount
	 */
	public Order(String category, String type, int amount){
		this.category = category;
		this.type = type;
		this.amount = amount;
		
		if(this.amount<=0) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * This method processes the order. Using the user inputted request values it 
	 * requests data from the database then calls the sort class to sort
	 * the data and find the cheapest combination of furniture or find if the order is impossible. 
	 * This method then calls either successfulOrder or failedOrder.
	 */
	public void processOrder(){
		Database data = new Database("jdbc:mysql://localhost/inventory","scm","ensf409");
		data.initializeConnection();
		//checks which type of furniture is being ordered, if an invalid type is entered an exception is thrown.
		if(this.category.equals("chair")) {
			 Sort sorter = new Sort();
			 sorter.powerSetChair(data.getChairs(type));
			 String[] result = sorter.sort(category,amount);
			 //if an order fails a string array is returned with one element "impossible" so failed order is called else the order
			 //was a success
			 if(result[0].equals("impossible")) {
				 this.failedOrder();
			 }
			 else {
				 this.successfulOrder(result);
			 }
		}
		else if(this.category.equals("desk")) {
			Sort sorter = new Sort();
			 sorter.powerSetDesk(data.getDesks(type));
			 String[] result = sorter.sort(category,amount);
			 //if an order fails a string array is returned with one element "impossible" so failed order is called else the order
			 //was a success
			 if(result[0].equals("impossible")) {
				 this.failedOrder();
			 }
			 else {
				 this.successfulOrder(result);
			 }
		}
		else if(this.category.equals("filing")) {
			Sort sorter = new Sort();
			 sorter.powerSetFiling(data.getFilings(type));
			 String[] result = sorter.sort(category,amount);
			 //if an order fails a string array is returned with one element "impossible" so failed order is called else the order
			 //was a success
			 if(result[0].equals("impossible")) {
				 this.failedOrder();
			 }
			 else {
				 this.successfulOrder(result);
			 }
		}
		else if(this.category.equals("lamp")) {
			Sort sorter = new Sort();
			 sorter.powerSetLamp(data.getLamps(type));
			 String[] result = sorter.sort(category,amount);
			 //if an order fails a string array is returned with one element "impossible" so failed order is called else the order
			 //was a success
			 if(result[0].equals("impossible")) {
				 this.failedOrder();
			 }
			 else {
				 this.successfulOrder(result);
			 }
		}
		else {
			System.out.println("Invalid category entered, try again.");
			throw new IllegalArgumentException();
		}
		
	}
	
	/**
	 * This method is called if an order can be fulfilled. It generates an order form and deletes the ordered furniture from the database.
	 * @param result is a string array containing the ID numbers of the furniture to be ordered a long with the total price in the final index.
	 */
	public void successfulOrder(String[] result) {
		try {	//This try is where the order form is generated.
			File output = new File("order form.txt");
			output.createNewFile();
			FileWriter fw = new FileWriter(output);
			PrintWriter pw = new PrintWriter(fw);	
			pw.println("Furniture Order Form");
			pw.println();
			pw.println("Faculty Name:");
			pw.println("Contact:");
			pw.println("Date:");
			pw.println();
			pw.println("Original Request: " + this.type.toLowerCase() + " " + this.category.toLowerCase() + ", " + amount);
			pw.println();
			pw.println("Items Ordered");
			for(int i = 0; i<result.length-1; i++) {
				pw.println("ID: " + result[i]);
			}
			pw.println();
			pw.println("Total Price: " + result[result.length-1]);
			pw.close();
			fw.close();
		}catch(IOException e) {	//if the order form fails exit the system.
			System.out.println("Failed. The order should have been successful but the order form failed to generate.");
			System.exit(1);
		}
		
		//below is used to delete the ordered furniture from the database
		Database data = new Database("jdbc:mysql://localhost/inventory","scm","ensf409");
		data.initializeConnection();
		
		for(int i = 0; i<result.length-1; i++) {
			if(result[i].charAt(0)=='C') {
				data.deleteChair(result[i]);
			}
			else if(result[i].charAt(0)=='D') {
				data.deleteDesk(result[i]);
			}
			else if(result[i].charAt(0)=='F') {
				data.deleteFiling(result[i]);
			}
			else if(result[i].charAt(0)=='L') {
				data.deleteLamp(result[i]);
			}
		}
		
		//below formats and outputs a string to console informing the user of the purchase.
		StringBuffer out = new StringBuffer();
		out.append("Purchase ");
		for(int i = 0; i<result.length; i++) {
			out.append(result[i]);
			if(i+1<result.length && i+2<result.length) {
				out.append(" and ");
			}
			else if(i+1<result.length) {
				out.append(" for $");
			}
			else if(i==result.length-1) {
				out.append(".");
			}
		}
		
		System.out.println(out);
	}
	
	/**
	 * This function is called if an order is unable to be fulfilled.
	 *  It finds the reccomended manufacturers and outputs them to the console.
	 */
	public void failedOrder() {
		Database data = new Database("jdbc:mysql://localhost/inventory","scm","ensf409");
		data.initializeConnection();
		ArrayList<String> finalList = new ArrayList<String>();
		
		//below find the type of furniture ordered then cross references its manufactures with a list of manufactures from the database.
		//The names of these manufactures are placed in finalList
		if(category.equals("chair")) {
			ArrayList<String> IDs = data.getChairManufacturers();
			ArrayList<Manufacturer> manu = data.getManufacturers();
					
			for(int i = 0; i<manu.size(); i++) {
				Manufacturer man = manu.get(i);
				for(int j = 0; j<IDs.size(); j++) {
					if(man.getManuID().equals(IDs.get(j))) {
						finalList.add(man.getName());
					}
				}
			}	
		}
		else if(category.equals("desk")) {
			ArrayList<String> IDs = data.getDeskManufacturers();
			ArrayList<Manufacturer> manu = data.getManufacturers();
					
			for(int i = 0; i<manu.size(); i++) {
				Manufacturer man = manu.get(i);
				for(int j = 0; j<IDs.size(); j++) {
					if(man.getManuID().equals(IDs.get(j))) {
						finalList.add(man.getName());
					}
				}
			}
		}
		else if(category.equals("lamp")) {
			ArrayList<String> IDs = data.getLampManufacturers();
			ArrayList<Manufacturer> manu = data.getManufacturers();
					
			for(int i = 0; i<manu.size(); i++) {
				Manufacturer man = manu.get(i);
				for(int j = 0; j<IDs.size(); j++) {
					if(man.getManuID().equals(IDs.get(j))) {
						finalList.add(man.getName());
					}
				}
			}
		}
		else if(category.equals("filing")) {
			ArrayList<String> IDs = data.getFilingManufacturers();
			ArrayList<Manufacturer> manu = data.getManufacturers();
					
			for(int i = 0; i<manu.size(); i++) {
				Manufacturer man = manu.get(i);
				for(int j = 0; j<IDs.size(); j++) {
					if(man.getManuID().equals(IDs.get(j))) {
						finalList.add(man.getName());
					}
				}
			}
		}
		
		//below formats a string and outputs it to the console.
		StringBuffer manus = new StringBuffer();
		for(int i = 0; i<finalList.size(); i++) {
		
			manus.append(finalList.get(i));
			if(i+1<finalList.size() && i+2<finalList.size()) {
				manus.append(", ");
			}
			else if(i+1<finalList.size()) {
				manus.append(", and ");
			}
			else if(i==finalList.size()-1) {
				manus.append(".");
			}
	
		}
		
		System.out.println("Order cannot be fulfilled based on current inventory. Suggest manufacturers are " + manus.toString());
	}
	
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/**
	 * The main is where the code is run. It will create an Order object then sort and output the result.
	 * @param args not used for this.
	 */
	public static void main(String[] args) {
		Order order = new Order();
		order.processOrder();
	}
		
}
