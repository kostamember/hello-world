package simpleAlgo;

import java.util.Scanner;


public class PrimeNumberIdentification {
	private static Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(true) {
		System.out.print("Input number: ");
		int primeNum = kb.nextInt();
		if (checkPrime_c(primeNum)) {
			System.out.println(primeNum+" is prime number ");
		} else {
			System.out.println("It's not prime number");
		}
	}
		
}
	// ���� �ܼ��� ������ �Ҽ� �Ǻ����̴�.
	public static boolean checkPrime_a(int primeNum) {
		if(primeNum == 1) {
			return false;
		}
		for(int i=2; i<primeNum; i++) {
		
			if (primeNum%i == 0) {
				return false;
			} 
		}
		
		return true;
	}
	// primeNum�� �߰������� ������ ���� �ȴ�
	public static boolean checkPrime_b(int primeNum) {
		if(primeNum == 1) {
			return false;
		}
		for(int i=2; i<=(primeNum/2); i++) {
		
			if (primeNum%i == 0) {
				return false;
			} 
		}
		
		return true;
	}
	// ��� �����ٱ����� ��������� �ȴ�
	public static boolean checkPrime_c(int primeNum) {
		if(primeNum == 1) {
			return false;
		}
		for(int i=2; i*i<=primeNum; i++) {
		
			if (primeNum%i == 0) {
				return false;
			} 
		}
		
		return true;
	}
	
}
