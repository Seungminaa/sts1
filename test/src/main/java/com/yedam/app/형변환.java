package com.yedam.app;

/*
 * char - Character
 * byte - Byte
 * int - Integer
 * short - Short
 * long - Long
 * float -Float
 * double - Double
 * boolean - Boolean
 * 
 * */

public class 형변환 {
	public static void main(String[] args) {
		// other type ==> string
		Integer score = 100;
		String s = Integer.toString(score);
		
		double avg = 90.5;
		s = Double.toString(avg);
		
		//string ==> other type
		score = Integer.parseInt(s);
		avg = Double.parseDouble(s);
		

	}
}
