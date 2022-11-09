
public class JavaStrings {
	
	/**
	 * This method removes leading and trailing white spaces from 2 strings then concatinates them together
	 * @param s1 The first String
	 * @param s2 The second String
	 * @return The length of the concatinated strings
	 */
	int addTogether(String first, String second){
		
		String s1 = first.trim();
		String s2 = second.trim();
		String concated = s1.concat(s2);
		return concated.length();
	}
	
	/**
	 * This method creates an ID for each individual pet. The idea follows the format of:
	 * OwnersFirstInital,OwnersLastInital,PetsInital,PetsYearOfBirth. ex/EMD2010
	 * @param firstName The first name of the owner.
	 * @param lastName The last name of the owner.
	 * @param petName The name of the pet.
	 * @param year The year the pet was born.
	 * @return The generated ID is returned as a String.
	 */
	String idProcessing(String firstName, String lastName, String petName, int year) {
		
		StringBuilder ID = new StringBuilder(7);
		String temp;
		temp = String.valueOf(firstName.charAt(0));
		ID.append(temp);
		temp = String.valueOf(lastName.charAt(0));
		ID.append(temp);
		temp = String.valueOf(petName.charAt(0));
		ID.append(temp);
		temp = String.valueOf(year);
		ID.append(temp);
		temp = String.valueOf(ID);
		return temp;
	}
	
	/**
	 * This method takes in an ingredient then replaces all the vowels with z. Then the word is shortend to only its first 3 letters/
	 * @param ingredient The ingredient that will be put into code
	 * @return The code generated for the ingredient. Will be a 3 character long string.
	 */
	String secretCode(String ingredient) {
		
		String s1 = ingredient.replace('a','z');
		String s2 = s1.replace('e','z');
		String s3 = s2.replace('i','z');
		String s4 = s3.replace('o','z');
		String s5 = s4.replace('u','z');
		
		StringBuilder code = new StringBuilder(3);
		
		code.append(s5.charAt(0));
		code.append(s5.charAt(1));
		code.append(s5.charAt(2));
		
		String finalcode = String.valueOf(code);
		return finalcode;
	}
	
	/**
	 * Testing Only
	 * @param args Not used
	 */
	public static void main(String[] args) {
		
		JavaStrings Str = new JavaStrings();
		System.out.println(Str.addTogether("  tomato    ","   Hello     "));
		System.out.println(Str.idProcessing("Big","Fat","Cat",1689));
		System.out.println(Str.secretCode("tomato"));
	}
	

}