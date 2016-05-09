import java.util.Scanner;
import java.util.Random;

public class testWriteChars {

	public static void writeChars(int n){
		Random r = new Random();
		
		char x = (char) ((char)r.nextInt(74) + 48);
		
		if (n == 0)
			return;
		else{
			writeChars(n-1);
			System.out.print(x);
			System.out.print(" ");
		}
		
	}
 
	

	public static void main(String[] args) {
		int N;
		Scanner input = new Scanner(System.in);

		System.out.print("Enter N  ==> ");
		N = input.nextInt();

		writeChars(N);
		System.out.println();

	}
}
