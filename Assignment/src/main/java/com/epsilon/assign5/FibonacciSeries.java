package com.epsilon.assign5;

import com.epsilon.utils.KeyBoardUtil;

public class FibonacciSeries {
	
	int f1 = 0, f2 = 1, f3;
	public int fibonacci(int index) { 
		for(int i = 2; i <= index; i++ ) {
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
		return f3; 
	}

	public static void main(String[] args) {
		
		int num,result;
		
		FibonacciSeries f = new FibonacciSeries();
		num = KeyBoardUtil.getInt("Enter the index: ");
		result = f.fibonacci(num);	
		
		System.out.println("The fibonacci number at the index " + num + " is: "+ result);

	}

}
