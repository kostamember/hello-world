package studyAlgo_Chapter1;

public class Code02_SequencialAnother {
	
	public static void main(String[] args) {
		int [] data = new int[] {1,7,3,4,11,2};
		int target = 11;
		int position = search(data, 0, data.length-1, target);
		System.out.println(position);
	}

	private static int search(int[] data, int begin, int end, int target) {
		if(begin > end) 
			return -1;
		else if(target == data[end]) 
			return end;
		else 
			return search(data, begin, end-1, target);
		
	}
	
	

}

