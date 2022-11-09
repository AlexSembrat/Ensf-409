/**
@author Alexander Sembrat <a href="mailto:alexander.sembrat@ucalgary.ca">
	alexander.sembrat@ucalgary.ca</a>
@version 1.5
@since   1.0
*/
 
/*
	This program implements the class Animal.
	Animal has 2 private variables of type int and String with names legs and color respectively.
	Animal contains a default constructor as well as 2 overloaded constructors. 
		The default constructor gives color a NULL value and the legs a value of 4
		The first overloaded constructor brings in a String and sets color eqaul to the String. Legs are set to 4.
		The second overloaded construcor brings in a String and an int. color is set to the string value and legs are set to the int value.
*/

public class Animal{
	
	
	private int legs;
	private String color;
	
	/**
	Overloaded construcor. Requires s of variable type String and i of variable type int. Sets color = s, legs = i.
	@param s is a param of type String. Color is set eqaul to s.
	@param i is a param of type int. legs is set eqaul to i.
	*/
	
	public Animal(String s, int i){  
		color = s;
		legs = i;
	}
	
	/**
	Overloaded constructor. Requires s of variable type String. Sets color = s, legs = 4.
	@param s is a param of type String. Color is set eqaul to s.
	*/
	
	public Animal(String s){ 
		color = s;
		legs = 4;
	}
	
	/**
	default constructor. Sets legs = 4.
	*/
	
	public Animal(){ 
		legs = 4;
	}
	
	/**
	Returns the value of legs.
	@return The value of legs is returned.
	*/
	
	public int getLegs(){ 
		return legs;
	}
	
	/**
	Sets the value of legs.
	@param i is a param of type int. legs are set equal to i.
	*/
	
	public void setLegs(int i){ 
		legs = i;
	}
	
	/**
	Returns the value of color.
	@return The value of color is returned.
	*/
	
	public String getColor(){ 
		return color;
	}
	
	/**
	Sets the value of color.
	@param s is a param of type String. color is set equal to s.
	*/
	
	public void setColor(String s){ 
		color = s;
	}
	
	/**
	The main method is simply used for testing purposes. 
	@param args are not used in this program and are therefore optional. 	
	*/
	
	public static void main(String[] args){
		Animal a = new Animal("blue");
		System.out.println(a.getColor() + a.getLegs());
		a.setLegs(10);
		a.setColor("red");
		System.out.println(a.getColor() + a.getLegs());
	}
}