package lecture01;
// n��° �Ǻ���ġ ���� ���Ѵ�.
public class Recursion_Fibonacci {

	public static void main(String[] args) {
		int result = fibonacci(10);
		System.out.println(result);

	}

	private static int fibonacci(int n) {
		// n�� 0�̸� 0��, 1�̸� 1�� �����ϸ� �Ǵϱ�.
		if(n < 2) 
			return n;
		else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}

}
