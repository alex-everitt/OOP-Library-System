package library;

public class Magazine extends Book{
	//main constructor
	public Magazine(int id, String name, String authors, String publisher, int year){
		super(id, name, authors, publisher, year);
		this.setLateFee(0.75);
	}
	//copy constructor
	Magazine (Magazine toCopy){
		super(toCopy.getID(),toCopy.getName(),toCopy.getAuthors(), toCopy.getPublisher(), toCopy.getYear());
		this.setLateFee(toCopy.getLateFee());
	}
	
	@Override
	public Magazine clone(){
		return new Magazine(this);
	}
	public boolean equals(Object otherObject){
		if(otherObject==null)
			return false;
		else if(this.getClass() !=otherObject.getClass())
			return false;
		else{
			Magazine otherBook= (Magazine) otherObject;
			return(this.getName().equals(otherBook.getName())&&this.getAuthors().equals(otherBook.getAuthors())&&this.getPublisher().equals(otherBook.getPublisher())&&this.getYear()==otherBook.getYear());
		}
	}
}
