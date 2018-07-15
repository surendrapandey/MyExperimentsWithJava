import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThreeWayPartition {

	public static void main(String[] args) throws IOException {
		
		
		
	}
	
	public ArrayList<Integer> threeWayPartition(ArrayList<Integer> arr, int low, int high)
	{
		
		ArrayList<Integer> mainList = new ArrayList<>();
		for(Integer i : arr) {
			if(i < low) {
				mainList.add(i);
			}
		}
		for(int j : arr) {
			if(j<=high && j>=low) {
				mainList.add(j);
			}
		}
		for(int j : arr) {
			if(j> high) {
				mainList.add(j);
			}
		}
		return mainList;
	
	}
}
