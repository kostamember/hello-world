package MyRectangle;

import java.util.Scanner;

public class LottoGameReal {

	static int [] guessNum = new int[6];
	static int [] lottoNum = new int[7];
	static int count = 0;	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		System.out.println("***로또 게임***");
		while(true) {
			System.out.print("로또 번호 6개를 입력하세요 : ");
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
				System.out.println("꽝! 하나도 못 마추셨네요ㅜㅠ");
				break;
			case 1:
				System.out.println("꽝! 하나 맞추셨어요.");
				break;
			case 2:
				System.out.println("꽝! 두 개 맞추셨습니다.");
				break;
			case 3:
				System.out.println("4등 당첨: 상금 5천원");
				break;
			case 4:
				System.out.println("3등 당첨: 상금 5만원");
				break;
			case 5:
				for(int i=0; i<6; i++) {
					if(lottoNum[6] == guessNum[i]) {
						System.out.println("2등 당첨: 상금 1억원");
					} else {
						System.out.println("3등 당첨: 상금 150만언");
					}
				}
				break;
			case 6:
				System.out.println("1등 당첨: 상금 10억");
				break;
			}
			count = 0;
			
			System.out.println("당첨번호: ");
			for (int i = 0; i < 6; i++) {
				System.out.print("[" + lottoNum[i] + "] ");
			}
				System.out.print("보너스 번호"+"{"+lottoNum[6]+"}");
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
