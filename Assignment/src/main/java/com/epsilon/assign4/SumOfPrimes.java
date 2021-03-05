package com.epsilon.assign4;

import com.epsilon.utils.KeyBoardUtil;

public class SumOfPrimes {
	private int sum = 0;
	static boolean isPrime(int num) {
		for (int i = 2, lim = num / 2; i <= lim; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public int sumOfPrimes(int from, int to) { 
		
		for (int i = from; i <= to; i++) {
			if (isPrime(i)) {
				sum+=i;
			}
		}
		return sum; 
	}
	
	
	public static void main(String[] args) {
		SumOfPrimes s = new SumOfPrimes();
		String in = "yes";
		int from, to;
		int result;
		
		while(in.equalsIgnoreCase("yes")) {
			from = KeyBoardUtil.getInt("Enter the number: ");
			to = KeyBoardUtil.getInt("Enter the number: ");
			result = s.sumOfPrimes(from,to);	
			
			System.out.println("Sum of the prime numbers is: "+ result);
			
			in = KeyBoardUtil.getString("Do you want to try another number? yes/no: ");
		}
		System.out.println("Thank you");

	}

}
