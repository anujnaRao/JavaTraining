package com.epsilon.trainig.utils;

import java.util.Scanner;

public class KeyBoardUtil {
	public static int getInt(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public static String getString(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public static double getDouble(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextDouble();
	}
}
