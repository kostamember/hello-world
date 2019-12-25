package lecture01;

public class Recursion03_Factorial {

	public static void main(String[] args) {
		int result = factorial(5);
		System.out.println(result);
	}

	private static int factorial(int i) {
		if(i<= 0) 
			return 1;
		else {
			return i*factorial(i-1);
		}
	
	}

}
