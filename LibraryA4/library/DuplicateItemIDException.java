package library;
import java.util.*;

public class DuplicateItemIDException extends java.lang.Exception {

	public DuplicateItemIDException(){
		super("Error, item ID is already in use");
	}
	public DuplicateItemIDException(String message){
		super(message);
	}
	
}
