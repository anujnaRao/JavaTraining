package com.epsilon.assign6;

import com.epsilon.utils.KeyBoardUtil;

public class Pattern {

	public static void print(int num) {
		for(int i = 1; i <=num; i++ ) {
			for(int j=1; j<=i; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int num;
		num = KeyBoardUtil.getInt("Enter the number: ");
		print(num);
	}

}
