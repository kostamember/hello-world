package section5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import section5.MyDate;
// 이 스케쥴러 프로그램은 자바의 Arraylist를 활용하여 다시 짤 것이다. 
public class Scheduler {
	// 아래 주석 처리한 세 줄은 이제 필요가 없다. ArrayList가 이미 가지고 있기 때문에
//	public static int capacity = 10;
	public static ArrayList<Event> events = new ArrayList<>();
//	public static Event[] events = new Event[capacity];
//	public static int n = 0; // 배열의 크기
	private static Scanner kb;

	/*
	 * OneDayEvent [] oneday = new OneDayEvent[100]; DurationEvent [] duration = new
	 * DurationEvent[100]; DeadLinedEvent [] deadline = new DeadLinedEvent[100]; int
	 * n1 = 0; int n2 = 0; int n3 = 0;
	 */
	public void CommandProcessor() {
		kb = new Scanner(System.in);

		while (true) {
			System.out.print("$ ");
			String command = kb.next();
			if (command.equalsIgnoreCase("addevent")) {
				String str = kb.next();
				if (str.equalsIgnoreCase("oneday")) {
					handleAddOneEvent();
				} else if (str.equalsIgnoreCase("duration")) {
					handleAddDuration();
				} else if (str.equalsIgnoreCase("deadline")) {
					handleAddDeadLien();
				}
			} else if (command.equalsIgnoreCase("list")) {
				// 훨씬 더 추상적인 for문. events안에 있는 모든 Event ev에 대해서 아래를 실행하라.
				for(Event ev : events)			// enhanced for loop. 
					System.out.println("    "+ev.toString());
				
				/*
				 * for (int i = 0; i < events.size(); i++) {
				 * System.out.println(events.get(i).toString()); }
				 */
			} else if (command.equalsIgnoreCase("show")) {
				handleShow();
			} else if (command.equalsIgnoreCase("sort")) {
				Collections.sort(events); // Collections.sort는 정렬할게 배열이 아니라, ArrayList일 때. events안에 배열의 개수가 얼마인지는 어차피 events안에 다 들어있다
			} else if (command.equalsIgnoreCase("exit")) {
				break;
			}
		}
		kb.close();
	}

	private void handleShow() {

		String dateString = kb.next();
		MyDate theDate = parseDateString(dateString);
		for(Event ev : events) {
			// test if events[i] is relevant to the date, then print it;
			if (ev .isRelevant(theDate)) // Event 안에는 없다. isRelevant는. dynamic binding은? 그거는 실제로 코드를 실행할 떄 발생하는 것.
												// 컴파일러가 볼 떄는 Event안에는 isRelevant는 없으니까.
												// 그러면 events[i].toString은? 그거는 class Object가 toString을 가지고 있으니까. 컴파일러는
												// 그렇게 판단한다. 문법적으로는 문제가 없다. 실제로 프로그램이 실행될 때는 dynamic binding이 일어난다.
				System.out.println(ev.toString());

		}

	}

	private static void handleAddDeadLien() {
		// TODO Auto-generated method stub
		System.out.print("title: ");
		String title = kb.next();
		System.out.print("end: ");
		String end = kb.next();

		MyDate day = parseDateString(end);
		DeadLinedEvent dlv = new DeadLinedEvent(title, day);
		addEvent(dlv);
	}

	private static void handleAddDuration() {
		System.out.print("title: ");
		String title = kb.next();
		System.out.print("begin: ");
		String begin = kb.next();
		System.out.print("end: ");
		String end = kb.next();

		MyDate day1 = parseDateString(begin);
		MyDate day2 = parseDateString(end);
		DurationEvent dv = new DurationEvent(title, day1, day2);
		addEvent(dv);

	}

	private static void handleAddOneEvent() {

		System.out.print("title: ");
		String title = kb.next();
		System.out.print("Date: ");
		String d = kb.next();

		MyDate date = parseDateString(d);
		OneDayEvent ev = new OneDayEvent(title, date);
		addEvent(ev);
	}

	private static void addEvent(Event ev) {
		/*
		 * if (n >= capacity) { reallocate(); }
		 */
		events.add(ev);

	}

	/*
	 * private static void reallocate() { Event[] temp = new Event[capacity * 2];
	 * for (int i = 0; i < n; i++) { temp[i] = events[i]; } events = temp; capacity
	 * *= 2;
	 * 
	 * }
	 */

	private static MyDate parseDateString(String d) {
		String[] tokens = d.split("/");
		int year = Integer.parseInt(tokens[0]);
		int month = Integer.parseInt(tokens[1]);
		int day = Integer.parseInt(tokens[2]);
		MyDate date = new MyDate(year, month, day);

		return date;
	}

	public static void main(String[] args) {
		Scheduler app = new Scheduler();
		app.CommandProcessor();
	}

}
