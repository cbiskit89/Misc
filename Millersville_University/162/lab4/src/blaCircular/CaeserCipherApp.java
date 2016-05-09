//Cory Miller
//Partner: Becky Freedman

package blaCircular;
import java.util.Scanner;

public class CaeserCipherApp 
{
	public static void main(String[] args)
	{
	
		Scanner input = new Scanner(System.in);
		String inputText= "";
		String encodedText="";
		int displacement;
		char ch;
		
		CircularArrayQueue q1 = new CircularArrayQueue(3);
		
		System.out.print("Enter text to encode: ");
		inputText = input.nextLine();
		System.out.println("");
		
		/* Convert to uppercase */
		inputText = inputText.toUpperCase();
		
		
		System.out.print("You entered = " + inputText);
		System.out.println("");
		/* encode */
		
		System.out.print("Enter key 1: ");
		q1.enqueue(input.nextInt());
		System.out.print("Enter key 2: ");
		q1.enqueue(input.nextInt());
		System.out.print("Enter key 3: ");
		q1.enqueue(input.nextInt());
		
		System.out.println("");
		
		// ------------ encode string --------------------
		
		for (int j = 0; j<inputText.length(); j++)
		{
			ch = inputText.charAt(j);
			
			if ((int)ch == 32)
				encodedText += ch;
			else
			{
				displacement = q1.dequeue();
				q1.enqueue(displacement);
				encodedText += encodeChar(ch, displacement);
			}
		}
		// ----------- done encoding ---------------------
		
		System.out.print("Encoded Text = " + encodedText);
		System.out.println("");
	} // end main()
	//-------------------------------------------------------------
	public static char encodeChar(char ch, int displacement)
	{ 
		int x;
		char newChar;
		
		if (displacement < 0)
			displacement += 26;
			
		x = (int)ch;
	
		if ((x > 64)&& (x < 91))
			x += displacement;
	
		if (x>90)
			x -=26; // wrap around factor
	
		newChar = (char)x;
	
		return newChar;
	}
}

//if (x != 32)
//	encodeChar

