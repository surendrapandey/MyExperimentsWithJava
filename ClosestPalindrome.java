package com.practice.java;

import java.util.Scanner;

public class ClosestPalindrome {

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases !=0) {
			testCases--;
			int number = sc.nextInt();
			System.out.println(findPalidrome(number));
		}
		sc.close();
		System.out.println(System.currentTimeMillis() - t1);
	}
	private static int findPalidrome(int number) {
		if(isPalidrome(number) || number <10)
			return number;
		else {
			int low =number-1, high = number+1;
			while(low !=9) {
				if(isPalidrome(low))
					return low;
				else if(isPalidrome(high))
					return high;
				low--;high++;
			}
			return 9;
		}
	}
	private static boolean isPalidrome(int number) {
		int r;
		int sum = 0;
		 while(number >0) {
			 r = number%10;
			 sum = (sum*10)+r;
			 number = number/10;
		 }
		if(sum == number)
			return true;
		return false;
	}

}
