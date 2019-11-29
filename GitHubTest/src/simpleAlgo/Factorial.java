package simpleAlgo;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
	
		System.out.print("Factorial °è»ê±â: ");
		int num = kb.nextInt();
		int i = 0;
		int result = 1;
		for(i=0; i<num; i++) {
			result = (num-i)*result;
		}
		System.out.println(result);
	}
}
