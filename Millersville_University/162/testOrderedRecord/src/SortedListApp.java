import java.io.*;
import java.util.Scanner;

class SortedListApp
{
	public static void main(String[] args) throws FileNotFoundException
	{ 
		// Open a file to read
		int nextId;
		String nameFirst, nameLast;
		double gpa;
		SortedList theSortedList = new SortedList();
		String dataFile = "records.txt";
		Scanner readData = new Scanner(new File(dataFile));
	     while(readData.hasNext())
	     {
	    	 // read next token into nextID
	    	 nextId = readData.nextInt();
	    	 // read next token into nameFirst
	    	 nameFirst = readData.next();
	    	 // read next token into nameLast
	    	 nameLast = readData.next();
	    	 // read next token into gpa
	    	 gpa = readData.nextDouble();
	    	 // insert record into the sorted linked list 
	    	 theSortedList.insert(nextId, nameFirst, nameLast, gpa);
	     }
		
	     	theSortedList.displayList(); // display list
	} // end main
} // end class SortedListApp
////////////////////////////////////////////////////////////////
