import java.util.Scanner;

public class LottoGame02 {

	static int [] guessNum = new int[6];
	static int [] lottoNum = new int[7];
	static int count = 0;
	static Scanner kb = new Scanner(System.in);
	public void CommandProcessor() {
		
		
		while(true) {
			System.out.print("$ ");
			String command = kb.next();
			if(command.equalsIgnoreCase("try")) {
				handleTry();
			} else if(command.equalsIgnoreCase("auto")) {
				handleAuto();
			} else if(command.equalsIgnoreCase("exit")) {
				System.out.println("LottoGame version0.02 exit");
				break;
			}
		}
		
	}
	
	
	private void handleAuto() {
		int tryNum = kb.nextInt();
		for(int i=0; i<tryNum; i++) {
				lottoNumTry();
				lottoNumAn();
				compareNum();
		}
	}



	private void lottoNumTry() {
		for(int i=0; i<6; i++) {
			guessNum[i] = makeNum(); 
			for(int j=0; j<i; j++) {
				if(guessNum[j] == guessNum[i]) {
					i--;
				}
			}
		}
		bubbleSortForAuto();
		System.out.print("Auto Try Number: ");
		for(int i=0; i<6; i++) {
			System.out.print("["+guessNum[i]+"] ");
		}
		System.out.println();
		
		
	}


	private void handleTry() {
		for(int i=0; i<6; i++) {
			guessNum[i] = kb.nextInt();
		}
		lottoNumAn();
		compareNum();
		
	}



	private void compareNum() {
		for(int i=0 ; i<6; i++) {
			for(int j=0; j<6; j++) {
				if(lottoNum[i] == guessNum[j]) {
					count++;
				}
			}
		}
		showResult();
		
	}
		
	private void showResult() {
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



	private void lottoNumAn() {		
		for(int i=0; i<7; i++) {
			lottoNum[i] = makeNum(); 
			for(int j=0; j<i; j++) {
				if(lottoNum[j] == lottoNum[i]) {
					i--;
				}
			}
		}
		bubbleSort();
	}

	private static int makeNum() {
		return (int)(Math.random()*45)+1;
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
	private static void bubbleSortForAuto() {
		// TODO Auto-generated method stub
		for(int i=5; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(guessNum[j] > guessNum[j+1]) {
					int temp = guessNum[j+1];
					guessNum[j+1] = guessNum[j];
					guessNum[j] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		
		LottoGame02 app = new LottoGame02();
		app.CommandProcessor();
		
		
	}

}
