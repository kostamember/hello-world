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
		System.out.println("***�ζǰ���***");
		while (true) {	
			System.out.print(gameCoin+"���� ����, ���� �������� �Է��ϼ��� : ");
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
				System.out.println("2�� ��÷: ��� 150����");
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