package library;

public abstract class Item {
	private double rentalFee=0;
	private int ID;
	private String Name;
	static int Global_ID=0;
	private double lateFee;
	
	public Item(int ID, String name){
		this.ID=ID;//add catch for duplicate ids
		this.Name=name;
	}
	public Item(Item toCopy){
		this.ID=toCopy.ID;
		this.Name=toCopy.Name;
	}	
	
	//Getters and setters
	
	public int getID() {
		return ID;
	}
	
	public double getRentalFee() {
		return rentalFee;
	}
	public void setRentalFee(double rentalFee) {
		if(rentalFee<0){
			System.out.println("Invalid argument, could not set");
			return;
		}
		else{
			this.rentalFee=rentalFee;
		}
	}
	public void setID(int new_ID) {
		if(new_ID<0||new_ID<=Global_ID){
			System.out.print("Could not assign the new ID");
			return;
		}
		else{
		ID = new_ID;
		}
	}

	public String getName() {
		return Name;
	}
	
	public void setLateFee(double lateFee){
		this.lateFee=lateFee;
	}
	
	public double getLateFee(){
		return this.lateFee;
	}

	public void setName(String name) {
		if(name.equals(null)||name.equals("")){
			System.out.print("Invalid argument, could not set");
			return;
		}
		else{
			Name = name;
		}
	}

	public static int getGlobal_ID() {
		return Global_ID;
	}

	
}
