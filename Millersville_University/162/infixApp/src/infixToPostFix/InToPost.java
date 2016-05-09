package infixToPostFix;

public class InToPost 
{
	private StackX theStack;
	private String input;
	private String output = " ";
	//--------------------------------------------------------
	public InToPost(String in) // constructor
	{
	input = in;
	int stackSize = input.length();
	theStack = new StackX(stackSize);
	theStack.push('$');
	}
	//--------------------------------------------------------
	public String doTrans() // do translation to postfix
	{
        char ch;
        int n = input.length();
        
		for(int j = 0; j< n; j++)
		{
			ch = input.charAt(j);
			if (ch == '$')
				break;
			else
			{
				
				switch (ch)
				{
					case '+':
					case '-':
						checkOperator (ch, 1);
						break;
					case '*':
					case '/':
						checkOperator (ch, 2);
						break;
					case '(':
						theStack.push(ch);
						break;
					case ')':
						parenPop (ch);
						break;
					default:
						output = output + ch;
				}//end switch	
			}
		} // end for loop
		while (theStack.size() > 1)
			{
				output = output + theStack.pop();
			}
		return output;

	}// doTrans function
	
	
	//the checkOperator function is used to see whether the next character is a
	//+, -, *, or /, and if it is, it will determine where it goes in the postFix
	//translation or the inFix formula
	public void checkOperator (char currentOper, int operRank)
	{
		while (theStack.size() > 1) 
		{
			char prevOper = theStack.pop();
			if (prevOper == '(')
			{
				theStack.push(prevOper);
				break;
			}
			else //then check if it's +, -, *, or /
			{
				int operPrec; 	//to check if the previous operand should 
								//be before or after the new operand
				
				if (prevOper == '+' || prevOper == '-')
					operPrec = 1;
				else
					operPrec = 2;
				
				if (operPrec < operRank)
				{
					theStack.push(prevOper);
					break;
				} 
				else
				{
					if(prevOper != '(')
					{
						output += prevOper;
					}
				}
			}
		}
		theStack.push(currentOper);
	}//end checkOperator
	
	//if the next character is a ), this function will pop
	//until the preceding ( has been reached
	public void parenPop (char stksym)
	{
		while (theStack.size() > 1)
		{
			stksym = theStack.pop();
			if(stksym == '(')
				break;
			else
				output = output + stksym;
		}
	}//end parenPop
}// end class InToPost
