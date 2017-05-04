package library;

public class Laptop extends Device{
	//main constructor
	public Laptop(int id, String name, double rentalCost){
		super(id, name, rentalCost);
		this.setLateFee(5);
		this.setLateCostScale(0.2);
	}
	//copy constructor
	public Laptop(Laptop toCopy){
		super(toCopy.getID(),toCopy.getName(),toCopy.getRentalFee());
		this.setLateFee(toCopy.getLateFee());
		this.setLateCostScale(toCopy.getLateCostScale());
	}
	@Override
	public Laptop clone(){
		return new Laptop(this);
	}
	public boolean equals(Object otherObject){
		if(otherObject==null)
			return false;
		else if(this.getClass() !=otherObject.getClass())
			return false;
		else{
			Laptop otherDevice= (Laptop) otherObject;
			return(this.getName().equals(otherDevice.getName())&&this.getRentalFee()==otherDevice.getRentalFee()&&this.getLateCostScale()==otherDevice.getLateCostScale()&&this.getLateFee()==otherDevice.getLateFee());
		}
	}
	
}
