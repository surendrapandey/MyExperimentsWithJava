package com.practice.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NonRepeatingCharacter {

	public static void main(String[] args) throws IOException {
		long t1 = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		U:
		while(testCases !=0) {
			testCases--;
			int noOfCharacter = Integer.parseInt(br.readLine());
			String s = br.readLine();
			char[] ca = s.toCharArray();
			A:
			for(int i = 0; i< noOfCharacter; i++) {
				int j = i+1;
				for(; j<noOfCharacter; j++) {
					if(ca[i] == ca[j]) {
						continue A;
					}
				}
				if(j== noOfCharacter) {
					System.out.println(ca[i]);
					continue U;
				}else {
					System.out.println(-1);
				}
			}
		}
		System.out.println("Time taken to execure" + (System.currentTimeMillis() - t1));
	}
}
