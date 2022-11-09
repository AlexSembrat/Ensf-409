package edu.ucalgary.ensf409;
/**
 * Program version 20.0
 * @author Alexander Sembrat, Dylan Windsor, Matthew Ho. Group 36.
 * 
 * This class represents the Manufacturer and it has all the elements that the table manufacturer has.
 */
public class Manufacturer {
	
	private String manuID;
	private String name;
	private String phone;
	private String province;
	/**
	 * Constructor for Manufacturer
	 * @param manuID The manufacturer ID to be set to manuID
	 * @param name The manufacturer name to be set to name
	 * @param phone The manufacturer phone number to be set to phone
	 * @param province The manufacturer province to be set to province
	 */
	Manufacturer(String manuID, String name, String phone, String province){
		this.setManuID(manuID);
		this.setName(name);
		this.setPhone(phone);
		this.setProvince(province);
	}

	/**
	 * @return the manuID
	 */
	public String getManuID() {
		return manuID;
	}

	/**
	 * @param manuID the manuID to set
	 */
	public void setManuID(String manuID) {
		this.manuID = manuID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	
	
}
