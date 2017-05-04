package library;
import java.util.*;

public class WrongRentalCostException extends java.lang.Exception{
	
	public WrongRentalCostException(){
		super("Error, this rental cost is invalid");
	}
}
