package review191202;

import java.util.Scanner;

public class DiamondStars {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		int size = kb.nextInt();
		
		for(int i=0; i<size-1; i++) {
			for(int j=0; j<size-i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<=(i*2); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=size; i>0; i--) {
			for(int j=0; j<=size-i; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<(i*2); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		kb.close();
	}

}
