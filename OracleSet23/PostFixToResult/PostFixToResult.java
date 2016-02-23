import java.util.Scanner;
import java.util.Stack;


public class PostFixToResult
{
	public static void main(String[] args){

		
		Scanner in = new Scanner(System.in);
		String[] input = new String[in.nextInt()];
		for(int i = 0; i < input.length; i++)
			input[i] = in.next();
		System.out.println(reversePolishNotation(input));


	}

	public static int reversePolishNotation(String[] input)
	{
		String operators = "+-*/";
		Stack<String> stack = new Stack<String>();
		for(String s : input)
		{
			if(!operators.contains(s))
				stack.push(s);
			else
			{
				String a = stack.pop();
				String b = stack.pop();
				switch(s)
				{
					case "+" : stack.push(String.valueOf(Integer.valueOf(a) + Integer.valueOf(b)));
							   break;
					case "-" : stack.push(String.valueOf(Integer.valueOf(b) - Integer.valueOf(a)));
							   break;
					case "*" : stack.push(String.valueOf(Integer.valueOf(a) * Integer.valueOf(b)));
							   break;
					case "/" : stack.push(String.valueOf(Integer.valueOf(a) / Integer.valueOf(b)));
							   break;

				}
			
			}
		}
			return Integer.valueOf(stack.pop());
	}
}