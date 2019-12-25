package lecture01_2_RecursiveThinking;

public class Recursion02_PrintStr {

	public static void main(String[] args) {
		printStr("abcd");

	}

	private static void printStr(String str) {
		if(str.length()==0) 
			return;
		else {
			//System.out.print(str.charAt(0));
			printStr(str.substring(1));
			System.out.print(str.charAt(0));
		}
	}

}
