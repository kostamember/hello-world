package studyAlgo_Chapter1;

public class Code05_findMax {
	public static void main(String[] args) {
		
		int [] data = new int[] {1,7,3,4,11,2};
		int a= findMax(data, 0, data.length-1);
		System.out.println(a);
	}

	public static int findMax(int [] data, int begin, int end) {
		if(begin == end) 
			return data[begin];
		else { 
			int middle = (begin+end)/2;
			int max1 = findMax(data, begin, middle);
			int max2 = findMax(data, middle+1, end);
			
			return Math.max(max1, max2);
		}
	}
}
