package algo1231;

import java.util.Arrays;
import java.util.Collections;

public class Code01_ReverseNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long [] temp = solution(12862);
		for(int i=0; i<temp.length; i++) {
			System.out.print(temp[i]+", ");
		}
	}
	
	  public static long[] solution(long n) {
	      long [] answer = {};
	      String strN= String.valueOf(n);
	      String [] temp = strN.split("");
	      
	      Collections.reverse(Arrays.asList(temp));
	      
	      answer = new long[temp.length];
	      for(int i=0; i<temp.length; i++) {
	    	  answer[i] = Long.parseLong(temp[i]);
	      }
	     
	    
	      return answer;
	  }

}
