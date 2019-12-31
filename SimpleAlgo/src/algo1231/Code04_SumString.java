package algo1231;

public class Code04_SumString {

	public static void main(String[] args) {
		int a = solution(987);
		System.out.println(a);
	}
	
    public static int solution(int n) {
        int answer = 0;
        
        String strNum = String.valueOf(n);
        String [] temp = strNum.split("");
        
        for(int i=0; i<temp.length; i++) {
        	answer += Integer.parseInt(temp[i]);
        }

        return answer;
    }

}
