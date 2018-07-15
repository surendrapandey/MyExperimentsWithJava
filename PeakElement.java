import java.io.IOException;
import java.util.Scanner;

public class PeakElement {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		int [] arr;
		int i;
		while (testCases !=0) {
			testCases--;
			i=0;
			int elements = sc.nextInt();
			arr = new int[elements];
			for(; i<elements; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(peakElement(arr,elements));
			
		}
		sc.close();
		
	}

	private static int peakElement(int[] arr, int elements) {
		int i = 0;
		if(elements<3) {
			if(arr[0]>arr[1])
				return 0;
			else {
				return 1;
			}
		}else {
			for(i=1; i<elements-1; i++) {
				if(arr[i]> arr[i+1] && arr[i]> arr[i-1])
					return i;
			}
			return 1;
		}
	}

}
