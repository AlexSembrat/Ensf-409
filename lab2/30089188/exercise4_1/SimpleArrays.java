
import java.util.Arrays;

public class SimpleArrays {
	
	/**
	 * A variable array which is a String array with 4 elements
	 */
	private String[] array = new String[4];
	
	/**
	 * A constructor for the class SimpleArrays. Fills every element of array with s
	 * @param s is the string that every array element will be set equal to.
	 */
	SimpleArrays(String s){
		Arrays.fill(array, s);	
	}
	
	/**
	 * Overloaded constructor for SimpleArrays. Fills every index of array with "Hello, ENSF 409"
	 */
	SimpleArrays(){
		this("Hello, ENSF 409");
	}
	
	/**
	 * This method takes all the strings in an array starting at the specified index and concatinates them together
	 * @param arrayIndex An array index that tells the method where to start the concatination
	 * @return A String is returned that is the concatination of all strings in the array starting at the specifed index
	 */
	String arrayConcat(int arrayIndex) {
		
		array[arrayIndex]=array[arrayIndex];
		if(arrayIndex==array.length-1) {
			String concat = array[arrayIndex];
			return concat;
		}
		else {
			String concat = arrayCrop(arrayIndex,array.length-1);
			return concat;
		}
	}
	
	/**
	 * The overloaded version of arrayConcat. Concatinates the entire array of strings together from start to end.
	 * @return A String is returned that is the concatination of all strings in the array.
	 */
	String arrayConcat() {
		
		String concat = arrayConcat(0);	
		return concat;
	}
	
	/**
	 * Concaninates the strings in an array together starting at index start and ending at index end (inclusive).
	 * @param start The starting index
	 * @param end The ending index
	 * @return A string is returned that is the concatination of strings from index start to index end
	 */
	String arrayCrop(int start, int end) {
		
		if(start>end) {
			int temp = start;
			start =  end;
			end = temp;
		}
		
		if((start>array.length-1)||(end>array.length-1)) {
			return "Fail";
		}
		
		if(start==end) {
			return "Match";
		}
		
		int count = array.length;
		for(int i = start; i<array.length-1; i++) {
			count = count + array[i].length();
		}
		
		StringBuilder adder = new StringBuilder(count);
		adder.append(array[start]);
		
		for(int i = start+1; i<=end; i++) {
			adder.append("#");
			adder.append(array[i]);
		}
		String concat = String.valueOf(adder);
		return concat;			
	}
	
	/**
	 * used for testing only
	 * @param args not used
	 */
	public static void main(String[] args) {
		
		SimpleArrays simp = new SimpleArrays("Hello");
		
		simp.array[0] = "Hello";
		simp.array[1] = "There";
		simp.array[2] = "General";
		simp.array[3] = "Kenobi";

		System.out.println(simp.arrayConcat());
		System.out.println(simp.arrayConcat(2));
		System.out.println(simp.arrayConcat(3));
		System.out.println(simp.arrayCrop(2,3));
		System.out.println(simp.arrayCrop(0,4));
		System.out.println(simp.arrayCrop(2,2));
	}

}
