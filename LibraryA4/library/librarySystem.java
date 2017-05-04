package library;
import java.util.*;

import library.Rental.rentalStatus;

import java.io.*;

public class librarySystem {

	//private ArrayList<Rental> transactions; //Going to store all active transactions
	
	//Hash Maps for all instances, using IDs as key
	private HashMap<Integer,Item> itemSet;
	private HashMap<Integer,Customer> customerSet;
	private HashMap<Integer,Rental> transactionSet;
	
	//Main constructor
	public librarySystem(){
		//transactions = new ArrayList<Rental>();//store all active
		itemSet= new HashMap<Integer, Item>();
		customerSet= new HashMap<Integer, Customer>();
		transactionSet= new HashMap<Integer, Rental>();//store all total
	}
	//copy constructor
	librarySystem(librarySystem toCopy){
		//this.transactions = toCopy.transactions;
		this.itemSet=toCopy.getItemSet();
		this.customerSet=toCopy.getCustomerSet();
		this.transactionSet=toCopy.getTransactionSet();
	}	
	
	//Library operations
	public void addTransaction(Rental newRental){
		try{
			if(this.getTransactionSet().containsKey(newRental.getRentalID()))
					throw new DuplicateTransactionIDException();
			else{
				transactionSet.put(newRental.getRentalID(), newRental);
				if(newRental.isLate())
					newRental.setStatus(rentalStatus.LATE);
			}
		}
		catch (DuplicateTransactionIDException e){
			System.out.println(e.toString());
		}
	}//if active or late add to both active and total set, if closed add to total set
	
	public void addItem(Item toAdd){
		try{
			if(this.getItemSet().containsKey(toAdd.getID()))
				throw new DuplicateItemIDException();
			else{
			itemSet.put(toAdd.getID(), toAdd);
			}
		}
		catch(DuplicateItemIDException e){
			System.out.println(e.toString());
		}
	}
	
	public void addCustomer(Customer toAdd){
		try{
			if(this.getCustomerSet().containsKey(toAdd.getCustomerID()))
				throw new DuplicateCustomerIDException();
			else{
				customerSet.put(toAdd.getCustomerID(), toAdd);
			}
		}
		catch(DuplicateCustomerIDException e){
			System.out.println(e.toString());
		}
	}
	
	public HashMap<Integer, Item> getItemSet() {
		return itemSet;
	}
	public void setItemSet(HashMap<Integer, Item> itemSet) {
		this.itemSet = itemSet;
	}
	public HashMap<Integer, Customer> getCustomerSet() {
		return customerSet;
	}
	public void setCustomerSet(HashMap<Integer, Customer> customerSet) {
		this.customerSet = customerSet;
	}
	public HashMap<Integer, Rental> getTransactionSet() {
		return transactionSet;
	}
	public void setTransactionSet(HashMap<Integer, Rental> transactionSet) {
		this.transactionSet = transactionSet;
	}
	
	public librarySystem clone(){
		return new librarySystem(this);
	}
	public boolean equals(Object otherObject){
		librarySystem otherLib= (librarySystem) otherObject;
		if(otherObject==null)
			return false;
		else if(this.getClass() !=otherObject.getClass())
			return false;
		else if(this.getTransactionSet().size()==otherLib.getTransactionSet().size()){
			for(int i=0;i<this.getTransactionSet().size();i++){
				if(!otherLib.getTransactionSet().get(i).equals(this.getTransactionSet().get(i))){
					return false;
				}
			}
			for(int i=0;i<this.getCustomerSet().size();i++){
				if(!otherLib.getCustomerSet().get(i).equals(this.getCustomerSet().get(i))){
					return false;
				}
			}
			for(int i=0;i<this.getItemSet().size();i++){
				if(!otherLib.getItemSet().get(i).equals(this.getItemSet().get(i))){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public String toString(){
		return this.getTransactionSet().toString();
	}
}
