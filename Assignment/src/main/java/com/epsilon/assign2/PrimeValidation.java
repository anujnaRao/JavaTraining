package com.epsilon.assign2;

import com.epsilon.utils.KeyBoardUtil;

public class PrimeValidation {
	
	static boolean isPrimeNumber(int num) { 
		int lim = num/2;
		boolean isPrime = true;
		for(int i=2; i<lim; i++) {
			if(num%i==0) {
				isPrime = false;
				break;
			}
		}
		if(isPrime) {
			return true;
		}
		else{
			return false;
		} 
	}

	public static void main(String[] args) {
		String in = "yes";
		int num;
		boolean result;
		
		while(in.equalsIgnoreCase("yes")) {
			num = KeyBoardUtil.getInt("Enter the number: ");
			result = isPrimeNumber(num);	
			if(result) {
				System.out.println("Number is a valid prime number");
			}
			else {
				System.out.println("Number is not a valid prime number");
			}
			in = KeyBoardUtil.getString("Do you want to try another number? yes/no: ");
		}
		System.out.println("Thank you");


	}

}
