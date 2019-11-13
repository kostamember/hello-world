import java.util.Scanner;

public class RandomLetter {

	public static void main(String[] args) {			// 이름을 입력받아서 간단한 편지를 써 주는 프로그램
		// TODO Auto-generated method stub
		String [] firstWord = {"안녕하세요", "어서 오세요", "반갑습니다"};
		String [] secondWord = {"방문해주셔서 감사합니다", "또 오셨네요"};
		String [] thirdWord = {"다시 한 번 감사드립니다", "잘 해 드릴게요", "네!"};
		
		int firstNum = (int)(Math.random()*firstWord.length);
		int secondNum = (int)(Math.random()*secondWord.length);
		int thirdNum = (int)(Math.random()*thirdWord.length);
		
		
		System.out.println("이름을 입력해주세요: ");
		Scanner kb = new Scanner(System.in);
		
		String name = kb.next(); 
		
		System.out.println(name+"님 "+firstWord[firstNum]+ " "+secondWord[secondNum]+" "+thirdWord[thirdNum]);
		System.out.println("Hello");
		kb.close();
		
	}

}
