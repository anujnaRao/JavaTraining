package com.epsilon.assign15;

import java.util.InputMismatchException;

import com.epsilon.utils.KeyBoardUtil;

public class InputImplement {
	
	static String in = "yes";
	
	public static void main(String[] args) {
		
		int count = 0, intCount = 0, nonCount = 0, sum = 0;
		int intInput[] =  new int[100];
		String nonInput[] = new String[100];
		
		while(in.equalsIgnoreCase("yes")) {
			
			int input = 0;
			try {
				input = KeyBoardUtil.getInt("Enter the value: ");
//				System.out.println(input + count);
				count++;
				
				intInput[intCount] = input;
				intCount++;
				
				in = KeyBoardUtil.getString("Do you want to enter again? yes/no: ");
				for(int i = 0; i < intCount; i++) {
					sum+=intInput[i];
				}
				System.out.println(sum);
			} catch(InputMismatchException x) {
				System.out.println(x.getClass().getName());
				try {
					System.out.println(Integer.toString(input, 0));
					nonInput[nonCount] = Integer.toString(input, 0);
					nonCount++;
					in = KeyBoardUtil.getString("Do you want to enter again? yes/no: ");
					
				} catch(Exception e) {
					System.out.println(e.getClass().getName());
				}
			}
		}
		
		System.out.println("Number of inputs: "+ count);
		System.out.println("Number of integer inputs: "+ intCount);
		System.out.println("Number of non-integer inputs: "+ nonCount);
		System.out.println("Sum of all the integer inputs: "+ sum);

		System.out.println("All the integer inputs are: ");
		for (int i = 0; i < intCount; i++) {
			System.out.print(intInput[i] + " ");
		}
		System.out.println();
		System.out.println("All non-integer inputs are: ");
		for (int i = 0; i < nonCount; i++) {
			System.out.print(nonInput[i] + " ");
		}
		System.out.println();
		System.out.println("Thank you");

	}

}
