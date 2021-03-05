package com.epsilon.assign10;

public class ReverseString {

	public String reverseByWords(String sentence) { 
		 int i = sentence.length() - 1;
		    int start, end = i + 1;
		    String result = "";
		     
		    while(i >= 0)
		    {
		        if(sentence.charAt(i) == ' ')
		        {
		            start = i + 1;
		            while(start != end)
		                result += sentence.charAt(start++);
		             
		            result += ' ';
		             
		            end = i;
		        }
		        i--;
		    }
		     
		    start = 0;
		    while(start != end)
		        result += sentence.charAt(start++);
		     
		    return result;
	}
	
	public static void main(String[] args) {
		ReverseString r = new ReverseString();
		String out = r.reverseByWords("my name is vinod and i live in bangalore");
		System.out.println("Reversed sentence is: "+ out);
	}
}
