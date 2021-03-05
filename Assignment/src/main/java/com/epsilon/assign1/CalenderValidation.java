package com.epsilon.assign1;

import com.epsilon.utils.KeyBoardUtil;

public class CalenderValidation {

	static boolean isValidDate(int year, int month, int day) { 
		if (month < 1 || month > 12) {
			return false;
		} 
		else {
			switch(month) {
			case 2:
				if(year % 100 == 0 || year % 4 == 0 || year % 400 == 0) {
					if(day >= 1 && day <= 29) {
						return true;
					}
				}
				else {
					if(day >=1 && day <= 28) {
						return true;
					}
				 }
				break;
			case 4:
			case 6:
			case 9:
			case 11: if(day >= 1 && day <= 30) {
				return true;
			}
			break;
			default: if(day >= 1 && day <= 31) {
				return true;
			}
			break;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String in = "yes";
		int year,month,day;
		boolean result;
		while(in.equalsIgnoreCase("yes")) {
			year = KeyBoardUtil.getInt("Enter year");
			month = KeyBoardUtil.getInt("Enter month: ");
			day = KeyBoardUtil.getInt("Enter day: ");
			
			result = isValidDate(year,month,day);
			if(result) {
				System.out.println("Calender is valid ");
			}
			else {
				System.out.println("Calender is invalid ");
			}
			
			in = KeyBoardUtil.getString("Do you want to try another number? yes/no: ");
		}
		System.out.println("Thank you");

	}
}
