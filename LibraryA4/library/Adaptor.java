package library;

public class Adaptor extends Device{
	//main constructor
	public Adaptor(int id, String name, double rentalCost){
		super(id, name, rentalCost);
		this.setLateFee(2.5);
		this.setLateCostScale(0.15);
	}
	//copy constructor
	public Adaptor(Adaptor toCopy){
		super(toCopy.getID(),toCopy.getName(),toCopy.getRentalFee());
		this.setLateFee(toCopy.getLateFee());
		this.setLateCostScale(toCopy.getLateCostScale());
	}
	
	@Override
	public Adaptor clone(){
		return new Adaptor(this);
	}
	public boolean equals(Object otherObject){
		if(otherObject==null)
			return false;
		else if(this.getClass() !=otherObject.getClass())
			return false;
		else{
			Adaptor otherDevice= (Adaptor) otherObject;
			return(this.getName().equals(otherDevice.getName())&&this.getRentalFee()==otherDevice.getRentalFee()&&this.getLateCostScale()==otherDevice.getLateCostScale()&&this.getLateFee()==otherDevice.getLateFee());
		}
	}
}
