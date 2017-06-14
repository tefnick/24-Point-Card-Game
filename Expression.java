package cardGame;

import java.util.StringTokenizer; 
import java.util.ArrayList; 

/**
 * Creates an expression class that converts an expression from infix to postfix.
 * @author Nick Ruiz
 * @version 1.0
 */	

public class Expression {
	
	/**
	 * The String of this Expression.
	 */
	private String expression;
	
	/**
	 * Integers for evaluation method to store operand1, 
	 * operand2, and the result
	 */
	private static int operand1, operand2, result;
	
	/**
	 * The default constructor of this Expression.
	 */
	public Expression(){
		this.expression = null;
	}
	
	/**
	 * The default constructor of this Expression
	 * @param exp
	 */
	public Expression(String exp){
		this.expression = exp;
	}
	
	/**
	 * The infix to postfix conversion of this Expression.
	 * @param infixExpression
	 * @return ArrayList<String>
	 */
	public ArrayList<String> infixToPostfix(String infixExpression){
		
		StringTokenizer token = new StringTokenizer(infixExpression,"+-*/()", true);
		
		ArrayList<String> postFix = new ArrayList<String>();
		
		GenericStack<String> stack = new GenericStack<String>();
	
		while (token.hasMoreTokens()){
			String current = token.nextToken();
			if (!(current.equals("+") || current.equals("-") 
					|| current.equals("*") || current.equals("/") 
					|| current.equals("(") ||current.equals(")"))){
				postFix.add(current);
			}
			else if (current.equals("(")){
				stack.push(current);
			}
			else if (current.equals("+")
					||current.equals("-")
					||current.equals("*")
					||current.equals("/")){
				 if (stack.isEmpty()){
					stack.push(current);
				}
				else if (!stack.isEmpty() && (current.equals("+") || current.equals("-"))){
					while (!stack.isEmpty() && stack.peek().equals(")")){
						postFix.add(stack.peek());
						stack.pop();
					}
					stack.push(current);
				}
				else if (!stack.isEmpty() && (current.equals("*") || current.equals("/"))){
					while (!stack.isEmpty() && !stack.peek().equals(")") && !stack.peek().equals("+") && !stack.peek().equals("-")){
						postFix.add(stack.peek());
						stack.pop();
					}
				stack.push(current);
				}
				
			}
			else if (current.equals(")")){
				while (!stack.peek().equals("(")){
					postFix.add(stack.peek());
					stack.pop();
				}
				stack.pop();
			}			
		}
		while (!stack.isEmpty()){
			postFix.add(stack.peek());
			stack.pop();
		}
		return postFix;
	}
	
	/**
	 * The evaluation of this Expression.
	 * @param postFix
	 * @return An integer representing the result of this postfix expression
	 */
	public static int evaluate(ArrayList<String> postFix){
		
		GenericStack<String> stack = new GenericStack<String>();
		
		for (int i = 0; i < postFix.size(); i++){
			if (!(postFix.get(i).equals("+") 
					|| postFix.get(i).equals("-") 
					|| postFix.get(i).equals("*") 
					|| postFix.get(i).equals("/"))){
				stack.push(postFix.get(i));
			}
				else{
					if (postFix.get(i).equals("+")){
					operand2 = Integer.parseInt(stack.peek());
					stack.pop();
					operand1 = Integer.parseInt(stack.peek());
					stack.pop();
					result = operand1 + operand2;
					stack.push(Integer.toString(result));
				}
				else if (postFix.get(i).equals("-")){
					operand2 = Integer.parseInt(stack.peek());
					stack.pop();
					operand1 = Integer.parseInt(stack.peek());
					stack.pop();
					result = operand1 - operand2;
					stack.push(Integer.toString(result));
				}
				else if (postFix.get(i).equals("*")){
					operand2 = Integer.parseInt(stack.peek());
					stack.pop();
					operand1 = Integer.parseInt(stack.peek());
					stack.pop();
					result = operand1 * operand2;
					stack.push(Integer.toString(result));
				}
				else if (postFix.get(i).equals("/")){
					operand2 = Integer.parseInt(stack.peek());
					stack.pop();
					operand1 = Integer.parseInt(stack.peek());
					stack.pop();
					result = operand1 / operand2;
					stack.push(Integer.toString(result));
				}
			}
		}
		return Integer.parseInt(stack.peek());
	}
	
	
}