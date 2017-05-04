//By Alex Everitt, March 30 2017
//Student #1019771, 15aje
package library;

import java.io.FileNotFoundException;
import org.joda.time.*;

import library.Customer.customerSet;
import library.Rental.rentalStatus;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Date;

public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Generate all items
		Magazine a = new Magazine(1,"National Geographic", "Ronald McDonald", "We the best",1969);
		Book b = new Book(2,"Not to Hurt the Boy", "Harambe", "Penguin Publishing", 2016);
		Textbook c = new Textbook(3,"Math", "Smartmans", "Book boiz", 2006);
		Device d = new Device(4,"3DS", 3.50);
		Laptop e = new Laptop(5,"Thinkpad", 4.20);
		Adaptor f = new Adaptor(6,"Lightning to USB", 3);
		Item[] itemTest={a,b,c,d,e,f};
		
		//Generate all customers
		Customer.customerSet studentType = Customer.customerSet.STUDENT;
		Customer.customerSet employeeType = Customer.customerSet.STUDENT;
		Customer c1 = new Customer(1,"Bob", "Applied Science",employeeType);
		Customer c2 = new Customer(2,"Alex", "Eng", studentType);
		Customer c3 = new Customer(3,"Bob", "CompSci", studentType);
		Customer[] custTest={c1,c2,c3};
		
		//Rental date from the past. Construct in form (year,month,day,hour,minutes)
		DateTime d1 = new DateTime(2017,3,21,0,0);		
		
		//Generate all transaction
		Rental r1 = new Rental(a,1,c1,d1);
		Rental r2 = new Rental(b,2,c2,d1);
		Rental r3 = new Rental(c,3,c3,d1);
		Rental r4 = new Rental(d,4,c1,d1);
		Rental r5 = new Rental(e,5,c2,d1);
		Rental r6 = new Rental(f,6,c3,d1);
		Rental[] rentTest = {r1,r2,r3,r4,r5,r6};
		
		//Close transactions with old dates, all estimated return dates are set to be 7 days after rental begins
		r1.setReturnDate(new DateTime(2017,3,29,0,0));//1 day late, magazine
		r2.setReturnDate(new DateTime(2017,3,30,0,0));//2, book
		r3.setReturnDate(new DateTime(2017,4,1,0,0));//4, textbook
		r4.setReturnDate(new DateTime(2017,3,29,0,0));//1, device
		r5.setReturnDate(new DateTime(2017,4,2,0,0));//5, laptop
		r6.setReturnDate(new DateTime(2017,3,25,0,0));//not late, adaptor
		
		librarySystem testLib = new librarySystem();
		
		//Add items to overall item collection
		for(Item iNew: itemTest){
				testLib.addItem(iNew);
		}
		
		//testLib.addItem(x);//To test duplicate itemId exception type
		for(Customer cNew: custTest){
			testLib.addCustomer(cNew);
		}//Add customers to customer collection
		
		//testLib.addCustomer(y); //To test duplicate customerID exception type
		int i=0;
		for(Rental r: rentTest){
			testLib.addTransaction(r);
		}//add transactions to set & collection, get the keys to allow their values to be retrieved for testing
		
		double totalLate=0;
		double totalCost=0;
		System.out.println("LIST OF LATE RENTALS:");
		for(int key: testLib.getTransactionSet().keySet()){
			if(testLib.getTransactionSet().get(key).getStatus()==rentalStatus.LATE){
				System.out.println(testLib.getTransactionSet().get(key).toString());
				totalLate+=testLib.getTransactionSet().get(key).getLateFee();
				totalCost+=testLib.getTransactionSet().get(key).getTotalToBePaid();
			}
			else{
				//totalLate+=testLib.getTransactionSet().get(key).getLateFee();
				totalCost+=	testLib.getTransactionSet().get(key).getTotalToBePaid();
			}
		
		}//print late transactions and calculate fees (expect 0.75*1+0.5*2+4*1+2*1+5*5=$32.75 late fee)
		System.out.println("\nTotal late fees due: $"+totalLate);
		System.out.println("Overall total amount dued: $"+totalCost);
		}

}
