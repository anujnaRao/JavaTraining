package com.epsilon.assign11;

import com.epsilon.utils.KeyBoardUtil;

public class NumberDisplayAsText {
	
	public static String[] units = { "", "One", "Two", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };

			public static String[] tens = { 
					"", 		// 0
					"",		// 1
					"Twenty", 	// 2
					"Thirty", 	// 3
					"Forty", 	// 4
					"Fifty", 	// 5
					"Sixty", 	// 6
					"Seventy",	// 7
					"Eighty", 	// 8
					"Ninety" 	// 9
			};

		public static String inWords(int num)
		{
			if (num < 0) {
				return "Minus " + inWords(-num);
			}

			if (num < 20) {
				return units[num];
			}

			if (num < 100) {
				return tens[num / 10] + ((num % 10 != 0) ? " " : "") + units[num % 10];
			}

			if (num < 1000) {
				return units[num / 100] + " Hundred" + ((num % 100 != 0) ? " " : "") + inWords(num % 100);
			}

			if (num < 100000) {
				return inWords(num / 1000) + " Thousand" + ((num % 10000 != 0) ? " " : "") + inWords(num % 1000);
			}

			if (num < 10000000) {
				return inWords(num / 100000) + " Lakh" + ((num % 100000 != 0) ? " " : "") + inWords(num % 100000);
			}

			return inWords(num / 10000000) + " Crore" + ((num % 10000000 != 0) ? " " : "") + inWords(num % 10000000);
		}


	public static void main(String[] args) {
		
		int num;
	    System.out.println();
		num = KeyBoardUtil.getInt("Enter a number to convert into word format");
		System.out.println("Given number " + num + " = " + inWords(num));

	}

}
