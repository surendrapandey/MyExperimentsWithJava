import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class CountingElementInTwoArrays {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while (testCases !=0) {
			testCases--;
			int l1 = sc.nextInt();
			int []arr1 = new int[l1]; 
			int l2 = sc.nextInt();
			int []arr2 = new int[l2]; 
			int i = 0, temp;
			for(; i< l1; i++) {
				arr1[i] = sc.nextInt();
			}
			for(i = 0; i<l2;i++) {
				arr2[i]= sc.nextInt();
			}
			for(i=0; i< l1; i++) {
				temp =0;
				for(int j=0; j<l2; j++) {
					if(arr1[i]>= arr2[j]) {
						temp++;
					}
				}
				System.out.print(temp+" ");
			}
			System.out.println();
			
			
		}
		sc.close();
		
	}

}
