package library;

public class Device extends Item {
	private double lateCostScale;
	
	//main constructor
	public Device(int id, String name, double rentalCost){
		super(id, name);
		this.setRentalFee(rentalCost);
		this.lateCostScale=0.1;
		this.setLateFee(2);
	}
	//copy constructor
	public Device(Device toCopy){
		super(toCopy.getID(),toCopy.getName());
		this.setRentalFee(toCopy.getRentalFee());
		this.setLateFee(toCopy.getLateFee());
		this.setLateCostScale(toCopy.getLateCostScale());
	}
	
	@Override
	public String toString(){
		return("Type: "+this.getClass().getSimpleName()+", Name: "+this.getName()+", ID:"+this.getID()+", Rental Cost: $"+this.getRentalFee()+", Late fee for rentals: "+this.getLateCostScale()+ "xRental Cost"+ ", Late Cost: $"+this.getLateFee()+" per day");
	}
	public Device clone(){
		return new Device(this);
	}
	public boolean equals(Object otherObject){
		if(otherObject==null)
			return false;
		else if(this.getClass() !=otherObject.getClass())
			return false;
		else{
			Device otherDevice= (Device) otherObject;
			return(this.getName().equals(otherDevice.getName())&&this.getRentalFee()==otherDevice.getRentalFee()&&this.getLateCostScale()==otherDevice.getLateCostScale()&&this.getLateFee()==otherDevice.getLateFee());
		}
	}
	
	//getters and setters	
	public double getLateCostScale(){
		return this.lateCostScale;
	}
	
	public void setLateCostScale(double lateCostScale){
		if(lateCostScale<0){
			System.out.println("Invalid argument, could not set");
			return;
		}
		else{
			this.lateCostScale=lateCostScale;
		}
	}
	
	
}
