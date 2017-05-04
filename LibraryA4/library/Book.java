package library;

public class Book extends Item{
	private String authors;
	private String publisher;
	private int year;
	//main constructor
	public Book(int id, String name, String authors, String publisher, int year){
		super(id, name);
		this.authors=authors;
		this.publisher=publisher;
		this.year=year;
		this.setLateFee(0.5);
	}
	//copy constructor
	public Book(Book toCopy){
			super(toCopy.getID(),toCopy.getName());
			this.setAuthors(toCopy.getAuthors());
			this.setPublisher(toCopy.getPublisher());
			this.setYear(toCopy.getYear());
			this.setLateFee(toCopy.getLateFee());
		}
	
	@Override
	public String toString(){
		return("Type: "+this.getClass().getSimpleName()+", Name: "+this.getName()+", ID:"+this.getID()+", Author(s): "+this.getAuthors()+", Publisher: "+this.getPublisher()+ ", Year: "+this.getYear()+", Late Fees: $"+this.getLateFee()+" per day");
	}
	public Book clone(){
		return new Book(this);
	}
	public boolean equals(Object otherObject){
		if(otherObject==null)
			return false;
		else if(this.getClass() !=otherObject.getClass())
			return false;
		else{
			Book otherBook= (Book) otherObject;
			return(this.getName().equals(otherBook.getName())&&this.getAuthors().equals(otherBook.getAuthors())&&this.getPublisher().equals(otherBook.getPublisher())&&this.getYear()==otherBook.getYear());
		}
	}

	//Getters and setters
	/*public double getRentalFees(int daysLate){
		return 0;
	}
	
	public double getLateFees(int daysLate){
		double fee = this.getLateFee()*daysLate;
		return fee;
	}*/
	
	public String getAuthors() {
		return authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getYear() {
		return year;
	}

	public void setAuthors(String authors) {
		if((authors.equals(null)||authors.equals(""))){
			System.out.println("Invalid argument, could not set");
			return;
		}
		else{
		this.authors = authors;
		}
	}

	public void setPublisher(String publisher) {
		if((publisher.equals(null)||publisher.equals(""))){
			System.out.println("Invalid argument, could not set");
			return;
		}
		else
		this.publisher = publisher;
	}


	public void setYear(int year) {
		if((year<=0||year>2017)){
			System.out.println("Invalid argument, could not set");
			return;
		}
		else
		this.year = year;
	}
	
}
