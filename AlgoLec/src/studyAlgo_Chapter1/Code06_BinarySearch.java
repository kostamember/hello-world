package studyAlgo_Chapter1;

import java.util.Arrays;

public class Code06_BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] data = new String[] {"lion","tiger","cat","dog","dragon","unicon"};
		Arrays.sort(data);
		int a= binarySearch(data, "tiger", 0, data.length-1);
		System.out.println(a);
	}

	private static int binarySearch(String[] data, String target, int begin, int end) {
		
		if(begin > end) 
			return -1;
		else {
			int middle = (begin+end)/2;
			int compResult = target.compareTo(data[middle]);
			if(compResult == 0) 
				return middle;
			else if(compResult < 0)
				return binarySearch(data, target, begin, middle-1);
			else 
				return binarySearch(data, target, middle+1, end);
		}
		
		
		
	}

}
