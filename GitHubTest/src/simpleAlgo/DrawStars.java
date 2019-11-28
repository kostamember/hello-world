package simpleAlgo;

import java.util.Scanner;

public class DrawStars {
	public static void main(String[] args) {
		System.out.print("Input stars number: ");
		Scanner kb = new Scanner(System.in);
		int starRow = kb.nextInt();
		
		for(int i=0; i<starRow; i++) {
		
				for(int j=0; j<starRow-i; j++) {
					System.out.print(" ");
				}
				for(int j=0; j<i*2+1; j++) {					
					System.out.print("*");
				}
			
			
			System.out.println();
			}
		kb.close();
		}
		
	}

