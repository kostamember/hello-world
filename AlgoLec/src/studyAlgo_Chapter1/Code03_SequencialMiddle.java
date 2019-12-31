package studyAlgo_Chapter1;

public class Code03_SequencialMiddle {

	public static void main(String[] args) {
		int [] data = new int[] {1,7,3,4,11,2};
		int target = 11;
		int position = search(data, 0, data.length-1, target);
		System.out.println(position);
	}

	private static int search(int[] data, int begin, int end, int target) {
		if(begin > end) {
			return -1;
		}
		else {
			int middle = (begin+end)/2;
			if(data[middle] == target) 
				return middle;
			int index = search(data, begin, middle-1, target);
			if(index != -1) 
				return index;
			else 
				return search(data, middle+1, end, target);
		
	}
	
	}
	
}
