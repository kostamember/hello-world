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
					// 1초 쉬었다가, 비프음이 나게 해 주세요.
					// 이렇게 하지 않으면, 비프음이 3번 나지 않는다. 
					Thread.sleep(1300);
				} catch(Exception e) {
					System.out.println(e);
				}
			}
			System.out.print(hours + "시간 " + minutes + "분 " + seconds + "초가 지났습니다.");

		}
 	};
	public void getInput() throws Exception {
		
		
		Timer timer = new Timer();
		
		
		System.out.print("몇 시간, 분, 초 뒤에 알려드릴까요? ");
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
