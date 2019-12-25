package lecture01;

public class Recursion05_GCD {

	public static void main(String[] args) {
		int result = eucGCD(125, 127);
		int result2 = simGCD(125, 127);
		System.out.println(result);
		System.out.println(result2);
	}

	private static int simGCD(int i, int j) {
		
		if(j == 0) {
			return i;
		}
		else {
			return simGCD(j, i%j);
		}

	}

	private static int eucGCD(int i, int j) {
		if(i < j) {
			int temp = i;
			i = j;
			j = temp;
		}
		
		if(i%j == 0) {
			return j;
		}
		else {
			return eucGCD(j, i%j);
		}

	}

}
