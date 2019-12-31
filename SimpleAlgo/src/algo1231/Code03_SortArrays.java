package algo1231;

import java.util.Arrays;

public class Code03_SortArrays {

	public static void main(String[] args) {
		String [] str = new String[] {"sun", "bed", "car"};
		String [] str2 = new String[] {"abce", "abcd", "cdx"};
		
		String [] temp = solution(str, 1);
		String [] temp2 = solution(str2, 2);
		
		
		for(int i=0; i<temp.length; i++) {
			System.out.print(temp[i]+", ");
		}
		System.out.println();
		for(int i=0; i<temp2.length; i++) {
			System.out.print(temp2[i]+", ");
		}

	}

	  public static String[] solution(String[] strings, int n) {
	      //String[] answer = {};
	      char [] temp = new char[strings.length];
	      
	      Arrays.sort(strings);
	      
	      for(int i=0; i<temp.length; i++) {
	    	  temp[i] = strings[i].charAt(n);
	      }
	      
	      
	      
	      for(int i=temp.length-1; i>0; i--) {
	    	  for(int j=0; j<i; j++) {
	    		  if(temp[j] > temp[j+1]) {
	    			  char tem = temp[j];
	    			  temp[j] = temp[j+1];
	    			  temp[j+1] = tem;
	    			  
	    			  String strtem = strings[j+1];
	    			  strings[j+1] = strings[j];
	    			  strings[j] = strtem;
	    			  
	    		  }
	    	  }
	      }
	      
	      
	      
	      
	      
	      return strings;
	  }
	
	
}
