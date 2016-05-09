//Cory Miller

import java.util.InputMismatchException;
import java.util.Scanner;


public class hourGlass {
	public static void main (String[] args){
		int numStars = 0;
		Scanner scanner = new Scanner(System.in);

			try{
				System.out.println("How many stars for topmost and bottommost rows of hourglass?");
				numStars = scanner.nextInt();
				
				System.out.println();
				//if the input is a valid integer but less than 1 we don't print the hourglass
				if (numStars <= 0)
					System.out.println("Number cannot be less than 1.");
				else
					printHourGlass(numStars, numStars);
			}
			catch(InputMismatchException a){
				//if the user inputs a nonnumeric character we will not print the hourglass
				System.out.println("Invalid integer.");
			}
	}
	public static void printHourGlass(int stars, int spaces){
		if (stars == 0){
			//when the hourglass reaches the middle it begins to print the bottom
			printBottomHourGlass(1, spaces);
			return;
		}
		else{
			//we recursively print the spaces before the first star
			printPreSpaces(spaces - stars);
			//then we recursively print 1 * and 1 space
			printStars(stars);
			//change line
			System.out.println();
			//recursion to print next level of hourglass
			printHourGlass(stars - 1, spaces);	
		}
	}
	
	public static void printStars (int n){
		if(n == 0)
			return;
		else{
			System.out.print("* ");
			printStars(n-1);
			return;
		}
		
	}
	
	public static void printPreSpaces (int i){
		if(i==0)
			return;
		else{
			System.out.print(" ");
			printPreSpaces(i-1);
			return;
		}
	}
	
	public static void printBottomHourGlass (int str, int spcs){
		if (str > spcs)
			return;
		else{
			printPreSpaces(spcs - str);
			printStars(str);
			System.out.println();
			printBottomHourGlass(str + 1, spcs);
		}
	}
}
