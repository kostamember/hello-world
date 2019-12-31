package algo1231;

public class Code02_StringSplit {

	public static void main(String[] args) {
		String str = "abcdef";
		String a = solution(str);
		System.out.println(a);
	}

	private static String solution(String str) {
		
		String [] temp = str.split("");
		String result = "";
		if(temp.length%2 != 0) {
			result = temp[temp.length/2];
		} else {
			for(int i=(temp.length/2)-1; i<=(temp.length/2); i++) {
				result += temp[i];
			}
		}
		
		
		return result;
	}

}
