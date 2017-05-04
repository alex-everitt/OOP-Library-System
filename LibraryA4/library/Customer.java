package library;

public class Customer {

	private int customerID;
	private String name;
	private String department;
	private double discount;
	private customerSet customerType;
	
	public enum customerSet{STUDENT, EMPLOYEES}
	
	public Customer(int id, String name, String department, customerSet type){
		this.customerID=id; 
		this.name=name;
		this.department=department;
		this.customerType=type;
		if(type==customerSet.STUDENT){
			this.discount=0.75;
		}
		else
			this.discount=1;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public customerSet getCustomerType() {
		return customerType;
	}

	public void setCustomerType(customerSet customerType) {
		this.customerType = customerType;
	}
	
	
	
	
}
