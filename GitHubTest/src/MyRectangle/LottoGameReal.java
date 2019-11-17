package MyRectangle;

import java.util.Scanner;

public class LottoGameReal {

	static int [] guessNum = new int[6];
	static int [] lottoNum = new int[7];
	static int count = 0;	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		System.out.println("***�ζ� ����***");
		while(true) {
			System.out.print("�ζ� ��ȣ 6���� �Է��ϼ��� : ");
			for(int i=0; i<6; i++) {
				guessNum[i] = kb.nextInt();
			}
			
			for(int i=0; i<7; i++) {
				lottoNum[i] = makeNum(); 
				for(int j=0; j<i; j++) {
					if(lottoNum[j] == lottoNum[i]) {
						i--;
					}
				}
			}
			bubbleSort();
				
			for(int i=0 ; i<6; i++) {
				for(int j=0; j<6; j++) {
					if(lottoNum[i] == guessNum[j]) {
						count++;
					}
				}
			}
			
			switch (count) {

			case 0:
				System.out.println("��! �ϳ��� �� ���߼̳׿�̤�");
				break;
			case 1:
				System.out.println("��! �ϳ� ���߼̾��.");
				break;
			case 2:
				System.out.println("��! �� �� ���߼̽��ϴ�.");
				break;
			case 3:
				System.out.println("4�� ��÷: ��� 5õ��");
				break;
			case 4:
				System.out.println("3�� ��÷: ��� 5����");
				break;
			case 5:
				for(int i=0; i<6; i++) {
					if(lottoNum[6] == guessNum[i]) {
						System.out.println("2�� ��÷: ��� 1���");
					} else {
						System.out.println("3�� ��÷: ��� 150����");
					}
				}
				break;
			case 6:
				System.out.println("1�� ��÷: ��� 10��");
				break;
			}
			count = 0;
			
			System.out.println("��÷��ȣ: ");
			for (int i = 0; i < 6; i++) {
				System.out.print("[" + lottoNum[i] + "] ");
			}
				System.out.print("���ʽ� ��ȣ"+"{"+lottoNum[6]+"}");
			System.out.println();
					
		}
	}

	private static void bubbleSort() {
		// TODO Auto-generated method stub
		for(int i=5; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(lottoNum[j] > lottoNum[j+1]) {
					int temp = lottoNum[j+1];
					lottoNum[j+1] = lottoNum[j];
					lottoNum[j] = temp;
				}
			}
		}
	}

	private static int makeNum() {
		// TODO Auto-generated method stub
		return (int)(Math.random()*45)+1;
	}

}
