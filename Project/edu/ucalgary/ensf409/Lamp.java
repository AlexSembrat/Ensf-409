package edu.ucalgary.ensf409;
/**
 * Program version 20.0
 * @author Alexander Sembrat, Dylan Windsor, Matthew Ho. Group 36.
 * 
 * This class represents the Lamp furniture type, has all the elements that the table lamp has.
 */
public class Lamp {
	private String ID;
	private String type;
	private boolean base;
	private boolean bulb;
	private int price;
	private String manuID;
	/**
	 * Sets ID
	 * @param ID to be set to ID
	 */
	public void setID(String ID) {
		this.ID = ID;
	}
	/**
	 * Sets tyoe
	 * @param type to be set to type.
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * Sets base when given a char
	 * @param base to be set to base
	 */
	public void setBase(char base) {
		if(base == 'Y') {
			this.base = true;
		}
		else if(base == 'N') {
			this.base = false;
		}
	}
	/**
	 * Sets bulb when given a bulb
	 * @param bulb to be set to bulb
	 */
	public void setBulb(char bulb) {
		if(bulb == 'Y') {
			this.bulb = true;
		}
		else if(bulb == 'N') {
			this.bulb = false;
		}
	}
	/**
	 * sets base when given a boolean
	 * @param base to be set to base
	 */
	public void setBase(boolean base) {
		this.base = base;
	}
	/**
	 * sets bulb when given a boolean
	 * @param bulb to be set to bulb
	 */
	public void setBulb(boolean bulb) {
		this.bulb = bulb;
	}
	/**
	 * sets price
	 * @param price to be set to price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * manuID to be set to manuID
	 * @param manuID
	 */
	public void setManuID(String manuID) {
		this.manuID = manuID;
	}
	/**
	 * Gets ID
	 * @return ID
	 */
	public String getID() {
		return this.ID;
	}
	/**
	 * gets type
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	/**
	 * get base
	 * @return base
	 */
	public boolean getBase() {
		return this.base;
	}
	/**
	 * get bulb
	 * @return bulb
	 */
	public boolean getBulb() {
		return this.bulb;
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
	 * @param base set to base
	 * @param bulb set to bulb
	 * @param price set to price
	 * @param manuID set to manuID
	 */
	public Lamp(String ID, String type, char base, char bulb, int price, String manuID) {
		setID(ID);
		setType(type);
		setBase(base);
		setBulb(bulb);
		setPrice(price);
		setManuID(manuID);
	}
}