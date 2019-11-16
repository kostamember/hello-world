import java.util.Scanner;

public class LottoGame {
	static int[] lottoNum = new int[6];
	static int[] GuessNum = new int[6];
	static int n;
	static int count = 0;
	static int gameCoin = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner kb = new Scanner(System.in);
		System.out.println("***로또게임***");
		while (true) {	
			System.out.print(gameCoin+"번쨰 게임, 숫자 여섯개를 입력하세요 : ");
			for (int i = 0; i < 6; i++) {
				GuessNum[i] = kb.nextInt();
			}
			gameCoin++;
			for (int i = 0; i < 6; i++) {
				lottoNum[i] = (int) (Math.random() * 45) + 1;
				for (int j = 0; j < i; j++) {
					if (lottoNum[j] == lottoNum[i]) {
						i--;
					}
				}
			}

			bubbleSort();

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					if (GuessNum[i] == lottoNum[j]) {
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
				System.out.println("2등 당첨: 상금 150만원");
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
			System.out.println();
		}

	}

	private static void bubbleSort() {
		// TODO Auto-generated method stub
		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (lottoNum[j] > lottoNum[j + 1]) {
					int temp = lottoNum[j + 1];
					lottoNum[j + 1] = lottoNum[j];
					lottoNum[j] = temp;
				}
			}
		}
	}
}