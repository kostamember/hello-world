package ariehmetic;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ArithmeticGame {

	private static int count = 0;
	private static int point = 0;
	private static char a;
	private static int i;
	
	TimerTask task = new TimerTask() {
		public void run() {
				System.out.println();
				System.out.println("====Game Over====");
				resultPrint();
				System.exit(0);
		}
	};
	
	public void print() {
		
		Scanner kb = new Scanner(System.in);
		
		for (i = 0; i < 10; i++) {
			int num1 = randomNum();
			int num2 = randomNum();
			int symbol = randomChar();
			ToSymbol(symbol);
			
			System.out.print(count + 1 + ". " + num1 + " " + a + " " + num2 + " = ");
			count++;
			int Answer = calc(num1, num2, symbol);
			int myAnswer = kb.nextInt();
			
	
			if (Answer == myAnswer) {
				System.out.println("You right");
				point += 1;
			}	else {
				System.out.println("No, you suck");
			}
			
			
		}
		kb.close();
		resultPrint();
		
		
	}
	
	
	/*
	 * private void show() { int num1 = (int) (Math.random() * 100) + 1; int num2 =
	 * (int) (Math.random() * 100) + 1; //int answer = num1 + num2;
	 * 
	 * System.out.print(num1 + " + " + num2 + " = "); System.out.println();
	 * 
	 * }
	 */



	private void resultPrint() {
		System.out.println("당신은 "+point+"개 맞췄다");
		
	}



	private void TimeCheckInput() throws Exception{
		Timer timer = new Timer();
		
		timer.schedule(task, 10*6000);
		
		print();
		
		//timer.cancel();
		
		
	}

	private int calc(int num1, int num2, int symbol) {
		int answer = 0;
		if(symbol == 1) {
			answer = num1+num2;
		} else if(symbol == 2) {
			answer = num1 - num2;
		} else if(symbol == 3) {
			answer = num1 * num2;
		} 
		return answer;
		
	}

	private void ToSymbol(int symbol) {
		// TODO Auto-generated method stub
		if(symbol == 1) {
			a = '+';
		} else if(symbol == 2) {
			a = '-';
		} else if(symbol == 3) {
			a = 'x';
		}
	
	}



	private int randomNum() {
		// TODO Auto-generated method stub
		return (int)(Math.random()*100)+1;
	}
	
	
	private int randomChar() {
		
		return (int)(Math.random()*3)+1;
	}
		
	
	public static void main(String[] args) {
		ArithmeticGame app = new ArithmeticGame();
		try {
			app.TimeCheckInput();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
}
