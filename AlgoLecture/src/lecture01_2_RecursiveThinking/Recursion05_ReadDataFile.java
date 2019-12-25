package lecture01_2_RecursiveThinking;

import java.util.Scanner;

public class Recursion05_ReadDataFile {

	public static void main(String[] args) {
		int [] temp = new int[5];
		Scanner in = new Scanner(System.in);
		readFrom(5, temp, in);
		
		for(int i=0; i<temp.length; i++) {
			System.out.println(temp[i]);
		}
		

	}
	
	public static void readFrom(int n, int [] data, Scanner in) {
		if(n==0) 
			return;
		else {
			readFrom(n-1, data, in);
			data[n-1] = in.nextInt(); 
		}
	}
}
