import java.util.Scanner;

public class RandomLetter {

	public static void main(String[] args) {			// �̸��� �Է¹޾Ƽ� ������ ������ �� �ִ� ���α׷�
		// TODO Auto-generated method stub
		String [] firstWord = {"�ȳ��ϼ���", "� ������", "�ݰ����ϴ�"};
		String [] secondWord = {"�湮���ּż� �����մϴ�", "�� ���̳׿�"};
		String [] thirdWord = {"�ٽ� �� �� ����帳�ϴ�", "�� �� �帱�Կ�", "��!"};
		
		int firstNum = (int)(Math.random()*firstWord.length);
		int secondNum = (int)(Math.random()*secondWord.length);
		int thirdNum = (int)(Math.random()*thirdWord.length);
		
		
		System.out.println("�̸��� �Է����ּ���: ");
		Scanner kb = new Scanner(System.in);
		
		String name = kb.next(); 
		
		System.out.println(name+"�� "+firstWord[firstNum]+ " "+secondWord[secondNum]+" "+thirdWord[thirdNum]);
		System.out.println("Hello");
		kb.close();
		
	}

}
