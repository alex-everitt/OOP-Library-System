package library;
import java.util.*;

public class CustomerFileReadingException extends java.lang.Exception {

	public CustomerFileReadingException(){
		super("Error, the customer file could not be read");
	}
}
