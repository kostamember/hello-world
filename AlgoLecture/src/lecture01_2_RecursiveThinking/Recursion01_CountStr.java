package lecture01_2_RecursiveThinking;

public class Recursion01_CountStr {

	public static void main(String[] args) {
		int result = countStr("abcd");
		System.out.println(result);

	}

	private static int countStr(String str) {
		if(str.equals(""))
			return 0;
		else 
			return 1+countStr(str.substring(1));
		
	}

}
