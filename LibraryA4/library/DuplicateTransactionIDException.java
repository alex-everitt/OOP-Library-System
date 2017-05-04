package library;
import java.util.*;

public class DuplicateTransactionIDException extends java.lang.Exception {

	public DuplicateTransactionIDException(){
		super("Error, transaction ID is already in use");
	}
	public DuplicateTransactionIDException(String message){
		super(message);
	}
}
