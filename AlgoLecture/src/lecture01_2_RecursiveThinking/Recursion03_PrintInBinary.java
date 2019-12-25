package lecture01_2_RecursiveThinking;

public class Recursion03_PrintInBinary {

	public static void main(String[] args) {
		toBinary(10);

	}

	private static void toBinary(int n) {
		if(n <2) 
			System.out.print(n);
		else {
			
			toBinary(n/2);
			System.out.print(n%2);
		}
	}

}
