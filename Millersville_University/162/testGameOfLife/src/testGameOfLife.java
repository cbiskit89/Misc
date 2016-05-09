import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/* Cory Miller:
 * Your partener's name 
*/
public class testGameOfLife {

	static void fillZerosOnsides(int a[][])
	{ 
	 int i,j;
	 int n = a.length;
	
	 //zero out first column
     for (i = 0; i < n; i++)
    	 a[i][0]= 0;
     
     //zero out last column
     for (i = 0; i < n; i++)
    	 a[i][n-1]= 0;
 
     //zero out first row
     for (j = 0; j < n; j++)
    	 a[0][j]= 0;
   
     //zero out last row
     for (j = 0; j < n; j++)
    	 a[n-1][j]= 0;
			
	}
	
	 static void generateLifeGrid(int [][] a)
	 {
		 int i,j, k;
		 int n = a.length;
		 
	     Random r = new Random();
		 //Create a buffer on the sides
	    
	     fillZerosOnsides(a);
	     
	     //randomly fill the remaining grid
   
	     for (i = 1; i < n-1; i++)
	     for(j=1; j<n-1; j++) 
	     {// randomly generate entries
	    	 k = r.nextInt(3); // will generate 0, 1, 3
	    	 if (k == 0) a[i][j] = 0; else a[i][j] = 1; 
	    	 // the value stored in array[i,j] will be either 0 or 1
	     }
		 
	 }// generateLifeGrid 
	 
	    public static void generateLifeGrid(int [][] a, String fileName) throws FileNotFoundException {
	        int N = a.length;
	        int nextValue;
	        
	        Scanner input = new Scanner(new File(fileName));

	        
	        for (int i = 1; i < N-1; i++) {
	            for (int j = 1; j < N-1; j++) {
	            	// generate entries in the range of 1 to 5
	            	nextValue = input.nextInt();
	                a[i][j] = nextValue;
	            } // inner loop
	            	      
	        }// outer loop
	    }
	 
	 static int numNeighbors(int [][] a, int i, int j){
		 int count = 0;

			 for (int y = j-1; y <= j+1; y++){
						 count += a[i - 1][j];
						 count += a[i + 1][j];
			 }
			 
			 count += a[i][j-1];
			 count += a[i][j-1];
			 
		return count; 
	 }

	  
		 
	  
	 static void generateNextLifeGrid(int [][] a, int [][]b)
	 {
		 int n = a.length;
		 
		 for (int i = 1; i < n-1; i++){
			 for (int j = 1; j < n-1; j++){
				 
				 if (a[i][j] == 1 && numNeighbors(a, i, j) >= 2 && numNeighbors(a, i, j) <= 3){
					 b[i][j] = 1;
				 }
				 else if (a[i][j] == 0 && numNeighbors(a, i, j) == 3){
					 b[i][j] = 1;
				 }
				 else {
					 b[i][j] = 0;
				 }
			 }
		 }
		 
	} //generateNextLifeGrid
	
	 static void copy(int [][] a, int [][]b)
	 {/* copy a to b */
		 
		 int n = a.length;

		 for (int i = 0; i < n; i++)
			 for (int j = 0; j < n; j++)
				 b[i][j]= a[i][j];
	
	 }
	 
static void displayGrid(int a[][]){
		 int i,j;
		 int n = a.length;
		 // display the grid only, no buffer
		 System.out.println("---------------------------------------------------"); 
	     for (i = 1; i < n - 1; i++)
	     {// Display the array
	     for(j= 1; j< n - 1; j++) 
	    	 System.out.print("   " + a[i][j]);
	     System.out.println();
	     }
	 }//displayGrid
	 
	 public static void main(String[] args) throws FileNotFoundException
     {
	 final int ARRAY_SIZE = 12;
	 
     String inputFileName = "grid.txt";
     
	 int[][] currentLifeGrid = new int[ARRAY_SIZE][ARRAY_SIZE];         // make array
    // there will be zeros on the boundary
     
	 int [][] nextLifeGrid = new int [ARRAY_SIZE][ARRAY_SIZE];
     
	 // fill the grid with zero on sides
	  
      fillZerosOnsides(currentLifeGrid);

      generateLifeGrid(currentLifeGrid, inputFileName);
     
      copy(currentLifeGrid, nextLifeGrid);
     
      generateNextLifeGrid(currentLifeGrid,nextLifeGrid);
     
     // display arrays
  
     displayGrid(currentLifeGrid);
     
     displayGrid(nextLifeGrid);
     
     }  // end main()
}
