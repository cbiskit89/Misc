//Cory Miller
//Partner: Becky Freedman

import java.util.Scanner;

public class TowersApp {

	public static void main (String[] args){
		int n = 0;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Towers of Hanoi Game: Move N discs from pole 1 to pole" +
				" 4 using poles 2 and 3 as a temporary placement poles.");
		System.out.print("Please enter the numbers of discs to move: ");
		n = in.nextInt();
		System.out.println();
		
		move(n, 1, 4, 2, 3);
	}//end main
	
	public static void move(int n, int startPole, int endPole, int aux1, int aux2){
		if (n == 0){
			return;
		}
		else if (n == 1){
			displayMove(n, startPole, endPole);
			return;
		}
		else if (n == 2){
			displayMove(n-1, startPole, aux1);
			displayMove(n, startPole, endPole);
			displayMove(n-1, aux1, endPole);
			//move(n-1, endPole, aux2, startPole, aux1);
			return;
		}
		else {			
			move(n-2, startPole, aux2, aux1, endPole);
			displayMove(n-1, startPole, aux1);
			displayMove(n, startPole, endPole);
			displayMove(n-1, aux1, endPole);
			move(n-2, aux2, endPole, startPole, aux1);
		}
	}//end move
	
	public static void displayMove(int discNum, int fromPeg, int toPeg){
		System.out.println("Move " + discNum + " from " + fromPeg + " to " + toPeg);
	}
}//end class TowersApp
