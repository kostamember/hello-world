package lecture01;

public class Recursion04_Power {

	public static void main(String[] args) {
		int result = power(2, 10);
		System.out.println(result);
		

	}

	private static int power(int i, int j) {
		if(j<= 0) {
			return 1;
		} else {
			return i*(power(i, j-1));
		}
	}

}
