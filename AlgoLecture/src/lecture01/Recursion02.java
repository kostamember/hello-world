package lecture01;

// func(int n)�� ���� �ƴ� ���� n�� ���ؼ� 0���� n������ ���� �ùٷ� ����Ѵ�.


public class Recursion02 {

	public static void main(String[] args) {
		int result = func(4);
		System.out.println(result);

	}
	// �� �Լ��� mission�� 0~n������ ���� ���ϴ� ���̴�.
	
	private static int func(int i) {
		// n=0�̶�� ���� 0�̴�.
		if(i <= 0) 
			return 0;
		else {
			// n�� 0���� ũ�ٸ� 0���� n������ ���� 0���� n-1������ �տ� n�� ���� ���̴�.
			return i+func(i-1);
		}

	}

}
