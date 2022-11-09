package edu.ucalgary.ensf409;
/**
 * Program version 20.0
 * @author Alexander Sembrat, Dylan Windsor, Matthew Ho. Group 36.
 * 
 * This class represents the Desk furniture type, has all the elements that the table desk has.
 */
public class Desk {
	private String ID;
	private String type;
	private boolean legs;
	private boolean top;
	private boolean drawer;
	private int price;
	private String manuID;
	/**
	 * Sets the string ID.
	 * @param ID
	 */
	public void setID(String ID) {
		this.ID = ID;
	}
	/**
	 * sets type
	 * @param type is set to type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * set legs when given a char
	 * @param legs is set to legs
	 */
	public void setLegs(char legs) {
		if(legs == 'Y') {
			this.legs = true;
		}
		else if(legs == 'N') {
			this.legs = false;
		}
	}
	/**
	 * set top when given a char
	 * @param top is set to top
	 */
	public void setTop(char top) {
		if(top == 'Y') {
			this.top = true;
		}
		else if(top == 'N') {
			this.top = false;
		}
	}
	/**
	 * set drawer when given a char
	 * @param drawer is set to drawer
	 */
	public void setDrawer(char drawer) {
		if(drawer == 'Y') {
			this.drawer = true;
		}
		if(drawer == 'N') {
			this.drawer = false;
		}
	}
	/**
	 * set legs when given a boolean
	 * @param legs is set to legs
	 */
	public void setLegs(boolean legs) {
		this.legs = legs;
	}
	/**
	 * set top when given a boolean
	 * @param top is set to top
	 */
	public void setTop(boolean top) {
		this.top = top;
	}
	/**
	 * set drawer when given a boolean
	 * @param drawer is used to set drawer
	 */
	public void setDrawer(boolean drawer) {
		this.drawer = drawer;
	}
	/**
	 * sets price
	 * @param price set to price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * set manuID
	 * @param manuID is set to manuID
	 */
	public void setManuID(String manuID) {
		this.manuID = manuID;
	}
	/**
	 * get ID
	 * @return ID
	 */
	public String getID() {
		return this.ID;
	}
	/**
	 * get type
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	/**
	 * get legs
	 * @return legs
	 */
	public boolean getLegs() {
		return this.legs;
	}
	/**
	 * get top
	 * @return top
	 */
	public boolean getTop() {
		return this.top;
	}
	/**
	 * get drawer
	 * @return drawer
	 */
	public boolean getDrawer() {
		return this.drawer;
	}
	/**
	 * get price
	 * @return price
	 */
	public int getPrice() {
		return this.price;
	}
	/**
	 * get manuID
	 * @return manuID
	 */
	public String getManuID() {
		return this.manuID;
	}
	/**
	 * Constructor
	 * @param ID set to ID
	 * @param type set to type
	 * @param legs set to legs
	 * @param top set to top
	 * @param drawer set to drawer
	 * @param price set to price
	 * @param manuID set to manuID
	 */
	public Desk(String ID, String type, char legs, char top, char drawer, int price, String manuID) {
		setID(ID);
		setType(type);
		setLegs(legs);
		setTop(top);
		setDrawer(drawer);
		setPrice(price);
		setManuID(manuID);
	}	
}
