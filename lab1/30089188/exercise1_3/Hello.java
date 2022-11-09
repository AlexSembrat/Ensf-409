/**
@author Alexander Sembrat <a href="mailto:alexander.sembrat@ucalgary.ca">
	alexander.sembrat@ucalgary.ca</a>
@version 1.2
@since   1.0
*/


/*
This program uses 1 of every basic data type in java.
Both an automatic and explicit cast are implemented in the program.
	 
*/



public class Hello{
	
	/**
	This decleaes all different variable types then does automatic and explicit casting.
	The variable values are then printed.
	@param args are not used in this program and are therefore optional. 
	*/
	
	public static void main(String[] args){
		boolean b = true;
		char c = 'a';
		byte by = 8;
		short s = 11;
		int i = 50;
		long l = 90;
		float f = 123;
		double d = 65;
		
		d = i; //This is an automatic cast as the int i will fit into the variable type double.
		
		s = (short)l; //This is an explicit cast as the long l will not fit into the varible type short as long takes up more space. We must type cast l to make this work.
		
		
		System.out.println("Hello? " + b + " " + c + " " + by + " " + s + " " + i + " " + l + " " + f + " " + d); 
	}
}	

//somehow write to convert into other basic types of variables
