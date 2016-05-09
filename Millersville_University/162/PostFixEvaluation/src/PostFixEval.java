import java.util.StringTokenizer;
import java.util.Stack;

public class PostFixEval 
{
	private Stack<Integer> stack;
	
	public PostFixEval()
	{
		stack = new Stack<Integer>();
	}
	
	public int evaluate (String expression)
	{
			StringTokenizer a = new StringTokenizer(expression);
			String postFixEval;
			int x, y, answer = 0;
			
			while (a.hasMoreTokens())
			{
				postFixEval = a.nextToken();
				
				
				if (isOperator(postFixEval) && stack.size() > 1)
				{
					x = (stack.pop()).intValue();
					y = (stack.pop()).intValue();
					answer = evaluateOperator (postFixEval.charAt(0), x, y);
					stack.push(new Integer(answer));
				}	
				else
					stack.push (new Integer(Integer.parseInt(postFixEval)));
			}
			return answer;
	}//end of evaluate
	
	public boolean isOperator(String token)
	{
		return (token.equals("+") || token.equals("-") ||
				token.equals("*"));
	}//end of isOperator
	
	public int evaluateOperator (char operator, int x, int y)
	{
		int result = 0;
		
		switch (operator)
		{
		case '+':
			result = x + y;
			break;
		case '-':
			result = y - x;
			break;
		case '*':
			result = x * y;
			break;
		}
		return result;
	}//end of evaluateOperator
	
	public boolean isIntString(String s)
	{
		for (int i = 0; i < s.length(); i++)
		{
			if (!(s.charAt(i) <= '9' && s.charAt(i) >= '0'))
				return false;
		}
		return true;
	}
}
