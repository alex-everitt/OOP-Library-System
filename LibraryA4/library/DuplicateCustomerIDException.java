package library;
import java.util.*;

public class DuplicateCustomerIDException extends java.lang.Exception{

	public DuplicateCustomerIDException(){
		super("Error, customer ID is already in use");
	}
	public DuplicateCustomerIDException(String message){
		super(message);
	}
}
