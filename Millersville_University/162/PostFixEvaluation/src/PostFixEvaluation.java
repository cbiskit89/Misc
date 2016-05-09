//Cory Miller
//Partner: Becky Freedman
//Mid-term Lab

import java.util.Scanner;

public class PostFixEvaluation 
{
	public static void main (String[] args)
	{
		String postFixInput;
		int answer = 0;
		
		Scanner input = new Scanner(System.in);
		PostFixEval evaluation = new PostFixEval();
		
		System.out.print("Enter Post-Fix Expression using +, -, and * operators" + 
							" (seperate with spaces): ");
		postFixInput = input.nextLine();
		
		answer = evaluation.evaluate(postFixInput);
		
		System.out.println();
		System.out.println("Post-Fix Evaluation is: " + answer);
	}//end of main
}