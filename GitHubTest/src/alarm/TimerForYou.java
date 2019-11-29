package alarm;

import java.awt.Toolkit;
import java.util.Scanner;

import java.util.Timer;
import java.util.TimerTask;

public class TimerForYou {
	
	public String time;
	int hours;
	int minutes;
	int seconds;
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	
	TimerTask task = new TimerTask() {
		public void run() {
			for (int i = 0; i < 5; i++) {
				
				try {
					toolkit.beep();
					// 1�� �����ٰ�, �������� ���� �� �ּ���.
					// �̷��� ���� ������, �������� 3�� ���� �ʴ´�. 
					Thread.sleep(1300);
				} catch(Exception e) {
					System.out.println(e);
				}
			}
			System.out.print(hours + "�ð� " + minutes + "�� " + seconds + "�ʰ� �������ϴ�.");

		}
 	};
	public void getInput() throws Exception {
		
		
		Timer timer = new Timer();
		
		
		System.out.print("�� �ð�, ��, �� �ڿ� �˷��帱���? ");
		Scanner kb = new Scanner(System.in);
		time = kb.next();
		
		String [] result = time.split("/");
		
		hours = Integer.parseInt(result[0]);
		minutes = Integer.parseInt(result[1]);
		seconds = Integer.parseInt(result[2]);
		
		int sum = hours*3600+minutes*60+seconds;
		
		timer.schedule(task, 1000*sum);
			
		kb.close();
	}
	public static void main(String[] args) {
		TimerForYou app = new TimerForYou();
		try {
			app.getInput();
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
}
