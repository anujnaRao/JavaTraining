package com.epsilon.assign9;

public class SumOfEvenOdd {

	public int[] sumOfEvensAndOdds(int []nums) { 
		int seven = 0, sodd=0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] % 2 == 0) {
				seven+=nums[i];
			}
			else {
				sodd+=nums[i];
			}
		}
		int [] res = {seven,sodd};
		return res;
	}
	
	public static void main(String[] args) {
		SumOfEvenOdd s =  new SumOfEvenOdd();
		int [] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 
		int [] result = s.sumOfEvensAndOdds(nums);
		System.out.println("Result is : ");
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]+ " ");
		}
		System.out.println();
	}

}
