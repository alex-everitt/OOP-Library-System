package library;
import java.util.Date;
import org.joda.time.*;

public class Rental {
	private Item rentItem;
	private Customer customer;
	private int rentalID;
	private int customerId;
	private DateTime rentalDate;//uses joda Datetime
	private DateTime estReturn;
	private DateTime returnDate;
	private rentalStatus status;

	public enum rentalStatus{ACTIVE, LATE, CLOSED}
	
		//main constructor
		public Rental(Item rentItem, int id, Customer customer, DateTime rentalDate){
			this.rentalID=id;
			this.rentItem=rentItem;
			this.customer=customer;
			this.customerId=customer.getCustomerID();
			this.status=rentalStatus.ACTIVE;
			this.rentalDate= rentalDate;
			this.estReturn=this.rentalDate.plus(Period.days(7));//sets for an expected 7 day rental
			this.returnDate=null;
			
		}
		//copy constructor
		public Rental(Rental toCopy){
			this.setRentalID(toCopy.getRentalID());
			this.setRentItem(toCopy.getRentItem());
			this.setCustomerId(toCopy.getCustomerId());
			this.setCustomer(toCopy.getCustomer());
			this.setStatus(toCopy.getStatus());
			this.setRentalDate(toCopy.getRentalDate());
			this.setEstReturn(toCopy.getEstReturn());
		}
		//New functions
		public boolean isLate(){
			if(this.returnDate!=null){
				if(this.returnDate.isAfter(this.estReturn))
					return true;
			}
				return false;
			}
		
		public void isReturned(){
			DateTime current = new DateTime();
			this.returnDate=current;
			this.status=rentalStatus.CLOSED;
		}//if returned at the current time
		
		public int getDaysOut(){
			int diff = (int) (this.getReturnDate().minus(this.getRentalDate().getMillis()).getMillis());
			if(diff<=0)
				return 0;
			else
				return diff/(1000*60*60*24);
		}//get total days rented for rental cost
		
		public int getDaysLate(){
			int diff = (int) (this.getReturnDate().minus(this.getEstReturn().getMillis()).getMillis());
			if(diff<=0)
				return 0;
			else
				return diff/(1000*60*60*24);
		}//get how many days late for late cost
		
		public double getLateFee(){
			double fee = this.getDaysLate()*this.getRentItem().getLateFee();
				return fee;
		}//Get fee for days late
		
		public double getRentalCost(){
			double fee = this.getDaysOut()*this.getRentItem().getRentalFee();
			return fee;
		}//get total rental cost
		public double getTotalToBePaid(){
			double fee = this.getRentalCost()*this.getCustomer().getDiscount() + this.getLateFee();
			return fee;
		}//get total amount due after discount
		
		
		//getters and setters
		public Item getRentItem() {
			return rentItem;
		}

		public void setRentItem(Item rentItem) {
			this.rentItem = rentItem;
		}

		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		
		public int getRentalID() {
			return rentalID;
		}
		public void setRentalID(int rentalID) {
			this.rentalID = rentalID;
		}
		public DateTime getRentalDate() {
			return rentalDate;
		}
		public void setRentalDate(DateTime rentalDate) {
			this.rentalDate = rentalDate;
		}
		public DateTime getEstReturn() {
			return estReturn;
		}
		public void setEstReturn(DateTime estReturn) {
			this.estReturn = estReturn;
		}
		public DateTime getReturnDate() {
			return returnDate;
		}
		public void setReturnDate(DateTime returnDate) {
			this.returnDate = returnDate;
			this.status=rentalStatus.CLOSED;
		}//uhjnjknjnjk
		public rentalStatus getStatus() {
			return status;
		}
		public void setStatus(rentalStatus status) {
			this.status = status;
		}
		
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		@Override
		public String toString(){
			String x= this.getRentItem().toString();
			x+=", Rental status: ";
			x+=this.getStatus();
			return x;
		}//Adds rental status to the toString method in the item class
		public Rental clone(){
			return new Rental(this);
		}
		public boolean equals(Object otherObject){
			if(otherObject==null)
				return false;
			else if(this.getClass() !=otherObject.getClass())
				return false;
			else{
				Rental otherRental= (Rental) otherObject;
				return(this.getRentItem().equals(otherRental.getRentItem())&&this.getCustomerId()==otherRental.getCustomerId()&&this.getRentalDate()==otherRental.getRentalDate()&&this.getEstReturn()==otherRental.getEstReturn()&&this.getReturnDate()==otherRental.getReturnDate()&&this.getStatus()==otherRental.getStatus());
			}
		}
}
