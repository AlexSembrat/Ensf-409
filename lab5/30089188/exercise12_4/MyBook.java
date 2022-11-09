
/**
 * 
 * @author Alexander Sembrat
 * Class only used for testing
 *
 */
public class MyBook {
	/**
	 * Testing only
	 * @param args not used
	 */
	public static void main(String[] args) {
	
    }
}


/**
 * 
 * @author Alexander
 * A class that represents a book. Has a isbn, publicationyear and the number of pages.
 */
abstract class Book{
	/**
	 * isbn identifier
	 */
	private String isbn;
	
	/**
	 * year it was published
	 */
	private int publicationYear;
	
	/**
	 * number of pages
	 */
	private int pages;
	
	/**
	 * constuctor 
	 * @param isbn places isbn into the object variable isbn
	 * @param pages places pages into the object variable pages
	 */
	public Book(String isbn, int pages){
		this.setIsbn(isbn);
		this.setPages(pages);
	}
	
	/**
	 * Default constructor
	 */
	public Book() {
		
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the publicationYear
	 */
	public int getPublicationYear() {
		return publicationYear;
	}

	/**
	 * @param publicationYear the publicationYear to set
	 */
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	/**
	 * @return the pages
	 */
	public int getPages() {
		return pages;
	}

	/**
	 * @param pages the pages to set
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}

	
}

/**
 * 
 * @author Alexander
 * A class that is a subclass of book, if book is a hardcover
 */
abstract class Hardcover extends Book{
	
	/**
	 * The book has a binding
	 */
	abstract public void binding();
}

/**
 * 
 * @author Alexander
 *  A class that is a subclass of book, if book is a paperback
 */
abstract class Paperback extends Book{
	
	/**
	 * A function that reurns the coverArt
	 * @return Returns a basic string. Incomplete function
	 */
	public String coverArt() {
		String s = "Method coverArt called from Paperback";
		return s;
	}
}

/**
 * 
 * @author Alexander
 * A class that extends hardcover. If a book is a classic its part of this class.
 */
class Classic extends Hardcover{
	/**
	 * Original year of publication
	 */
	private int origPubYear = 1860;
	
	/**
	 * Author(s) of the book
	 */
	private Author theAuthor[];
	
	/**
	 * publisher(s) of the book
	 */
	private Publisher[] bookPublisher;
	
	/**
	 * Creates notes and returns them
	 * @return Returns a basic string. Incomplete function
	 */
	public String createNotes() {
		String s = "Method createNotes called from Classic";
		return s;
	}

	/**
	 * @return the origPubYear
	 */
	public int getOrigPubYear() {
		return origPubYear;
	}

	/**
	 * @param origPubYear the origPubYear to set
	 */
	public void setOrigPubYear(int origPubYear) {
		this.origPubYear = origPubYear;
	}

	/**
	 * @return the theAuthor
	 */
	public Author[] getTheAuthor() {
		return theAuthor;
	}

	/**
	 * @param theAuthor the theAuthor to set
	 */
	public void setTheAuthor(Author[] theAuthor) {
		this.theAuthor = theAuthor;
	}

	/**
	 * @return the bookPublisher
	 */
	public Publisher[] getBookPublisher() {
		return bookPublisher;
	}

	/**
	 * @param bookPublisher the bookPublisher to set
	 */
	public void setBookPublisher(Publisher[] bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	@Override
	/**
	 * binding extends from hardcover due to abstaction. Incomplete function
	 */
	public void binding() {
		
	}
}

/**
 * 
 * @author Alexander
 * A class that is the category of a book
 */
class Category{
	/**
	 * The subcateogry if it has one
	 */
	private Category subCategory;
	
	/**
	 *  The superCategory if it has one
	 */
	private Category superCategory;
	
	/**
	 * the category of the book
	 */
	private String category;
	
	/**
	 * Sorts and returns a string
	 * @return Returns a basic string. Incomplete function
	 */
	public String sort() {
		String s = "Method sort called from Category";
		return s;	
	}

	/**
	 * @return the subCategory
	 */
	public Category getSubCategory() {
		return subCategory;
	}

	/**
	 * @param subCategory the subCategory to set
	 */
	public void setSubCategory(Category subCategory) {
		this.subCategory = subCategory;
	}

	/**
	 * @return the superCategory
	 */
	public Category getSuperCategory() {
		return superCategory;
	}

	/**
	 * @param superCategory the superCategory to set
	 */
	public void setSuperCategory(Category superCategory) {
		this.superCategory = superCategory;
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
}

/**
 * 
 * @author Alexander
 * The non-fiction books
 */
class Nonfiction extends Paperback{
	/**
	 * The dewey decimal system classification
	 */
	private Category deweyClassification;
	
	/**
	 * Finds and returns the topic
	 * @return Returns a basic string. Incomplete function
	 */
	public String topic() {
		String s = "Method topic called from Nonfiction";
		return s;
	}

	/**
	 * @return the deweyClassification
	 */
	public Category getDeweyClassification() {
		return deweyClassification;
	}

	/**
	 * @param deweyClassification the deweyClassification to set
	 */
	public void setDeweyClassification(Category deweyClassification) {
		this.deweyClassification = deweyClassification;
	}
}

/**
 * 
 * @author Alexander
 * A class for fiction books
 */
abstract class Fiction extends Paperback{
	
	/**
	 * Returns a basic string. Incomplete function
	 */
	abstract public String coverArt();
	
	/**
	 * Finds and returns genre
	 * @return Returns a basic string. Incomplete function
	 */
	public String genre() {
		String s = "Method genre called from Fiction";
		return s;
	}
}

/**
 * 
 * @author Alexander
 * The type of story of a book.
 */
class Story{
	
	/**
	 * The author(s) of the book
	 */
	private Author[] theAuthor;
	
	/**
	 * Finds and returns the plot.
	 * @return Returns a basic string. Incomplete function
	 */
	public String plot() {
		String s = "Method plot called from Story";
		return s;
	}

	/**
	 * @return the theAuthor
	 */
	public Author[] getTheAuthor() {
		return theAuthor;
	}

	/**
	 * @param theAuthor the theAuthor to set
	 */
	public void setTheAuthor(Author[] theAuthor) {
		if(theAuthor[0]==null) {
			return;
		}
		else {
			this.theAuthor = theAuthor;
		}
	}
}

/**
 * 
 * @author Alexander
 * A class for anthologys
 */
class Anthology extends Fiction{
	/**
	 * The stoires in an anthology
	 */
	private Story[] story;
	
	/**
	 * Finds and returns the order of the stories
	 * @return Returns a basic string. Incomplete function
	 */
	public String storyOrder() {
		String s = "string";
		return s;
	}

	/**
	 * @return the story
	 */
	public Story[] getStory() {
		return story;
	}

	/**
	 * @param story the story to set
	 */
	public void setStory(Story[] story) {
		
		if(story[4] == null) {
			return;
		}
		else {
			this.story = story;
		}
	}

	@Override
	/**
	 * 
	 */
	public String coverArt() {
		return "Method coverArt called from Anthology";
	}
}

/**
 * 
 * @author Alexander
 * A class for novels.
 */
class Novel extends Fiction{
	/**
	 * The author(s) of the book
	 */
	private Author theAuthor[];
	
	/**
	 * The series a book is a part of
	 */
	private Series mySeries;
	
	/**
	 * Finds and returns theme.
	 * @return Returns a basic string. Incomplete function
	 */
	public String theme() {
		String s = "Method theme called from Novel";
		return s;
	}

	/**
	 * @return the theAuthor
	 */
	public Author[] getTheAuthor() {
		return theAuthor;
	}

	/**
	 * @param theAuthor the theAuthor to set
	 */
	public void setTheAuthor(Author[] theAuthor) {
		this.theAuthor = theAuthor;
	}

	/**
	 * @return the mySeries
	 */
	public Series getMySeries() {
		return mySeries;
	}

	/**
	 * @param mySeries the mySeries to set
	 */
	public void setMySeries(Series mySeries) {
		this.mySeries = mySeries;
	}

	@Override
	/**
	 * Find and returns cover art
	 * @return Returns a basic string. Incomplete function
	 */
	public String coverArt() {
		return "Method coverArt called from Novel";
	}
}

/**
 * 
 * @author Alexander
 * A class for publishers info
 */
class Publisher{
	/**
	 * Name of the publisher
	 */
	private String name;
	
	/**
	 * Address of the publisher
	 */
	private String address;
	
	/**
	 * The classics a publisher has
	 */
	private Classic[] classicsCatalog;
	
	/**
	 * Constructor
	 * @param name name is set equal to name in the object
	 * @param address address is set equal to address in the object
	 */
	public Publisher(String name, String address) {
		this.setName(name);
		this.setAddress(address);
	}
	
	/**
	 * Find and returns letterhead
	 * @return Returns a basic string. Incomplete function
	 */
	public String printLetterHead() {
		String s = "Method printLetterHead called from Publisher";
		return s;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the classicsCatalog
	 */
	public Classic[] getClassicsCatalog() {
		return classicsCatalog;
	}

	/**
	 * @param classicsCatalog the classicsCatalog to set
	 */
	public void setClassicsCatalog(Classic[] classicsCatalog) {
		
		if(classicsCatalog[0]==null) {
			return;
		}
		else {
			this.classicsCatalog = classicsCatalog;
		}
	}
}

/**
 * 
 * @author Alexander
 * Information about authors.
 */
class Author{
	/**
	 * Name of the author
	 */
	private String name = "Unknown";
	
	/**
	 * Address of the author
	 */
	private String address;
	
	/**
	 * Age of the author
	 */
	private int age;
	
	/**
	 * Constructor
	 * @param name is set equal to class variable name
	 * @param address is set equal to class variable address
	 * @param age is set equal to class variable age
	 */
	public Author(String name, String address, int age) {
		this.setName(name);
		this.setAddress(address);
		this.setAge(age);
	}
	
	/**
	 * Default constructor
	 */
	public Author() {
		
	}
	
	/**
	 * Dont know.
	 * @return Returns a basic string. Incomplete function
	 */
	public String write() {
		String s = "Method write called from Author";
		return s;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
}

/**
 * 
 * @author Alexander
 * A contract between authors and publishers
 */
class Contract{
	/**
	 * Date of signing
	 */
	private String date;
	
	/**
	 * The publisher
	 */
	private Publisher publisherInfo;
	
	/**
	 * The author(s)
	 */
	private Author authorInfo[];
	
	/**
	 * Constructor
	 * @param date is set equal to class variable date
	 * @param publisherInfo is set equal to class variable publisherInfo
	 * @param authorInfo if set equal to class variable authorInfo
	 */
	public Contract(String date, Publisher publisherInfo, Author[] authorInfo) {
		this.setDate(date);
		this.setPublisherInfo(publisherInfo);
		this.setAuthorInfo(authorInfo);
	}
	
	/**
	 * Prints and returns contract info
	 * @return Returns a basic string. Incomplete function
	 */
	public String printContract() {
		return "Method printContract called from Contract";
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the publisherInfo
	 */
	public Publisher getPublisherInfo() {
		return publisherInfo;
	}

	/**
	 * @param publisherInfo the publisherInfo to set
	 */
	public void setPublisherInfo(Publisher publisherInfo) {
		this.publisherInfo = publisherInfo;
	}

	/**
	 * @return the authorInfo
	 */
	public Author[] getAuthorInfo() {
		return authorInfo;
	}

	/**
	 * @param authorInfo the authorInfo to set
	 */
	public void setAuthorInfo(Author[] authorInfo) {
		this.authorInfo = authorInfo;
	}
}

/**
 * 
 * @author Alexander
 * The series a book is part of
 */
class Series{
	/**
	 * The name of a series
	 */
	private String seriesName;
	
	/**
	 * Finds and returns the theme.
	 * @return Returns a basic string. Incomplete function
	 */
	public String theme() {
		String s = "Method theme called from Series";
		return s;
	}

	/**
	 * @return the seriesName
	 */
	public String getSeriesName() {
		return seriesName;
	}

	/**
	 * @param seriesName the seriesName to set
	 */
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
}
