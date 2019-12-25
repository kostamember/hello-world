package lecture01;
// n번째 피보나치 수를 구한다.
public class Recursion_Fibonacci {

	public static void main(String[] args) {
		int result = fibonacci(10);
		System.out.println(result);

	}

	private static int fibonacci(int n) {
		// n이 0이면 0을, 1이면 1을 리턴하면 되니까.
		if(n < 2) 
			return n;
		else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}

}
