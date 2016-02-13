import java.util.*;

class ReversePolishNotation {
	
	//PROBLEM 2
	
	/*
	
	Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
	Valid operators are +, -, *, /. Each operand may be an integer or another expression. 
	
	For example:
	
	["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
	["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6 */
	
	public static void main(String[] args) {
		String [] tokens = new String[]{"4", "13", "99", "-", "8","12", "*", "/", "+"};
		System.out.println(reversePolishNotation(tokens));
	}
	
	public static int reversePolishNotation(String [] tokens){
		Stack<String> stack = new Stack<String>();
		String operators = "+-/*";
		
		for(String str:tokens){
			if(!operators.contains(str))
				stack.push(str);
			
			else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());			
				
				switch(str){
					
					case "+":
						stack.push(String.valueOf(a+b));
						break;
					
					case "-":
						stack.push(String.valueOf(a-b));
						break;

					
					case "*":
						stack.push(String.valueOf(a*b));
						break;

					
					case "/": {
						if(b!=0) {
							stack.push(String.valueOf(a/b));
							break;
						}
						else {
							stack.push("-1");
							break;
						}
					}
				}
			}
			
			//printStack(stack);
		}
		
		return Integer.valueOf(stack.pop());
	}
	
	public static void printStack(Stack<String>stack){
		for(String s: stack){
			System.out.print(s + " ");
		}
		System.out.println();
	}
	
}