package library;
import java.util.*;

public class ItemFileReadingException extends java.lang.Exception{
	
	public ItemFileReadingException(){
		super("Error, the item file could not be read");
	}
}
