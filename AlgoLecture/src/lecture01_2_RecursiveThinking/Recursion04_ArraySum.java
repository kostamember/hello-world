package lecture01_2_RecursiveThinking;

public class Recursion04_ArraySum {

	public static void main(String[] args) {
		int [] data = new int[] {1,2,3,4,5,6};
		int result = ArraySum(5, data);
		System.out.println(result);
	}

	private static int ArraySum(int n, int[] data) {
		if(n <= 0) 
			return 0;
		else {
			return ArraySum(n-1, data)+data[n-1];
		}
	}

}
