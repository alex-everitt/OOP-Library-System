package library;

public class Textbook extends Book {
	//main constructor
	public Textbook(int id, String name, String authors, String publisher, int year){
		super(id, name, authors, publisher, year);
		this.setLateFee(1);
	}
	//copy constructor
	Textbook(Textbook toCopy){
		super(toCopy.getID(), toCopy.getName(),toCopy.getAuthors(), toCopy.getPublisher(), toCopy.getYear());
		this.setLateFee(toCopy.getLateFee());
	}
	
	@Override
	public Textbook clone(){
		return new Textbook(this);
	}
	public boolean equals(Object otherObject){
		if(otherObject==null)
			return false;
		else if(this.getClass() !=otherObject.getClass())
			return false;
		else{
			Textbook otherBook= (Textbook) otherObject;
			return(this.getName().equals(otherBook.getName())&&this.getAuthors().equals(otherBook.getAuthors())&&this.getPublisher().equals(otherBook.getPublisher())&&this.getYear()==otherBook.getYear());
		}
	}
	
}
