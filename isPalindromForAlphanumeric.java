import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class isPalindromForAlphanumeric {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		while(testCase !=0) {
			testCase--;
			String s = br.readLine();
			System.out.println(isPalindrome(s.toCharArray()) ? "YES" : "NO");
		}
		br.close();
	}

	private static boolean isPalindrome(char[] charArray) {
		int i=0; int j=charArray.length-1;
		boolean isCharI= false;
		boolean isCharJ= false;
		while(i<j) {
			isCharI =isAlphaNumeric(charArray[i]);
			isCharJ =isAlphaNumeric(charArray[j]);
			if(isCharI && isCharJ) {
				if(Character.toLowerCase(charArray[i]) != Character.toLowerCase(charArray[j]))
					return false;
				i++; j--;
			}else {
				if(isCharI) {
					j--;
				}else {
					i++;
				}
			}
		}
		
		return true;
	}
	 private static boolean isAlphaNumeric(char c) {
	        if ((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
	            return true;
	        }
	        return false;
	    }

}
