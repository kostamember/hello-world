package lecture01;

// func(int n)은 음이 아닌 정수 n에 대해서 0에서 n까지의 합을 올바로 계산한다.


public class Recursion02 {

	public static void main(String[] args) {
		int result = func(4);
		System.out.println(result);

	}
	// 이 함수의 mission은 0~n까지의 합을 구하는 것이다.
	
	private static int func(int i) {
		// n=0이라면 합은 0이다.
		if(i <= 0) 
			return 0;
		else {
			// n이 0보다 크다면 0에서 n까지의 합은 0에서 n-1까지의 합에 n을 더한 것이다.
			return i+func(i-1);
		}

	}

}
