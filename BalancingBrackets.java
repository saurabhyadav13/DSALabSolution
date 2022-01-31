package com.xyz;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {

	
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the  Bracket Expression");
		String exp = sc.next();

		
		if (isbalanced(exp)) 
			System.out.println("Bracket Expression iss Balanced");
	 else 
			System.out.println("Bracket Expression is Not Balanced");
		

	}

	
	static boolean isbalanced(String bracketExpression) {

		Stack<Character> stack = new Stack<Character>();

		if (bracketExpression.length() % 2 == 1) {
			return false;
		} else {
			
			for (int i = 0; i < bracketExpression.length(); i++) {
				char ch = bracketExpression.charAt(i);

				if (ch == '{' || ch == '(' || ch == '[') {
					
					stack.push(ch);
				} else {
					
					if (stack.isEmpty())
						return false;
					char c = stack.pop();
					switch (ch) {
					case '}':
						if (c == '(' || c == '[') {
							return false;

						}
						break;

					case ')':
						if (c == '{' || c == '[') {
							return false;

						}
						break;

					case ']':
						if (c == '(' || c == '{') {
							return false;

						}
						break;
					}
				}
			}
		}
		
		return (stack.isEmpty());

	}

}
