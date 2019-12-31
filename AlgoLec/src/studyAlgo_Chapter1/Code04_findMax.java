package studyAlgo_Chapter1;

public class Code04_findMax {

	public static void main(String[] args) {
		int [] data = new int[] {1,7,3,4,11,2};
		int a= findMax(data, 0, data.length-1);
		System.out.println(a);
	}

	public static int findMax(int [] data, int begin, int end) {
		if(begin == end) 
			return data[begin];
		else 
			return Math.max(data[begin], findMax(data,begin+1, end));
	}
}
