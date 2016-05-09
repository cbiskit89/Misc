import java.util.Scanner;

public class convertToHexApp {

/* Convert from Decimal to Hex */
	    public static void convertToHexnumber(int n) {
	        int i = 0;
	    	if (n < 16){
	        	displayHexDigit(n);
	        }
	        else{
	        	i = n / 16;
	        	convertToHexnumber(i);
	        	displayHexDigit(n%16);
	        }
	        
	        
	        


	        
	    }
	    //--------------------------------------------------------
	    	    public static void displayHexDigit(int n) {
	    	        char sym;

	    	        if (n < 10)
	    	        	System.out.print(n);
	    	        else
	    	        {
		    	        switch (n){
		    	        	case 15: sym = 'F';
		    	        		break;
		    	        	case 14: sym = 'E';
		    	        		break;
		    	        	case 13: sym = 'D';
		    	        		break;
		    	        	case 12: sym = 'C';
		    	        		break;
		    	        	case 11: sym = 'B';
		    	        		break;
		    	        	default: sym = 'A';
		    	        }
	    	        System.out.print(sym);
	    	        }
	    	    }

	  
	    public static void main(String[] args) { 
	        int n;
	        Scanner input = new Scanner(System.in);
	        
	        System.out.print("Enter N  ==> ");
	        n = input.nextInt();
	        System.out.println("");

	        convertToHexnumber(n);    
	        
	    }
}
