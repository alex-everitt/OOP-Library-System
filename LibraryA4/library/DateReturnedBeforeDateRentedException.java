package library;
import java.util.*;

public class DateReturnedBeforeDateRentedException extends java.lang.Exception {

	public DateReturnedBeforeDateRentedException(){
		super("Error, date returned is before date rented");
	}
}
