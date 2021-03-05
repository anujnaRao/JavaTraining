package com.epsilon.assign3;

import com.epsilon.utils.KeyBoardUtil;

public class SortTheNumbers {
	
	public void sortThreeNumbers(int a, int b, int c) { 
		if( a > b && a > c ) {
			if( b > c) {
				System.out.print(c + " , "+ b + " ,");
			}
			else {
				System.out.print(b + " , "+ c + " ,");
			}
			System.out.println(a);
		}
		else if( b > a && b > c) {
			
			if( a > c) {
				System.out.print(c + " , "+ a + " ,");
			}
			else {
				System.out.print(a + " , "+ c + " ,");
			}
			System.out.println(b);
		}
		else {
			
			if( a < b) {
				System.out.print(a + " , "+ b + " ,");
			}
			else {
				System.out.print(b + " , "+ a + " ,");
			}
			System.out.println(c);
		}
	}
	
	public static void main(String[] args) {
		SortTheNumbers s = new SortTheNumbers();
		String in = "yes";
		int a,b,c;
		
		while(in.equalsIgnoreCase("yes")) {
			a = KeyBoardUtil.getInt("Enter the number: ");
			b = KeyBoardUtil.getInt("Enter the number: ");
			c = KeyBoardUtil.getInt("Enter the number: ");
			
			s.sortThreeNumbers(a, b, c);
			
			in = KeyBoardUtil.getString("Do you want to try another number? yes/no: ");
		}
		System.out.println("Thank you");



	}

}
