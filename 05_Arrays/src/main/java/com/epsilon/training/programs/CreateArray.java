package com.epsilon.training.programs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateArray {
	
	static Logger log = LoggerFactory.getLogger(CreateArray.class);
	
	public static void main(String[] args) {
		int nums[] = {10};
		System.out.println("nums: "+nums);
		
		nums = new int[] {10, 20};
		System.out.println("nums: "+nums);
		
		nums = new int[3];
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		System.out.println("nums: "+nums);
		
		for(int num:nums) {
			log.debug("nums is {}", num);
		}
	}
}
