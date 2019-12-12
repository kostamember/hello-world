package section5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import section5.MyDate;
// �� �����췯 ���α׷��� �ڹ��� Arraylist�� Ȱ���Ͽ� �ٽ� © ���̴�. 
public class Scheduler {
	// �Ʒ� �ּ� ó���� �� ���� ���� �ʿ䰡 ����. ArrayList�� �̹� ������ �ֱ� ������
//	public static int capacity = 10;
	public static ArrayList<Event> events = new ArrayList<>();
//	public static Event[] events = new Event[capacity];
//	public static int n = 0; // �迭�� ũ��
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
				// �ξ� �� �߻����� for��. events�ȿ� �ִ� ��� Event ev�� ���ؼ� �Ʒ��� �����϶�.
				for(Event ev : events)			// enhanced for loop. 
					System.out.println("    "+ev.toString());
				
				/*
				 * for (int i = 0; i < events.size(); i++) {
				 * System.out.println(events.get(i).toString()); }
				 */
			} else if (command.equalsIgnoreCase("show")) {
				handleShow();
			} else if (command.equalsIgnoreCase("sort")) {
				Collections.sort(events); // Collections.sort�� �����Ұ� �迭�� �ƴ϶�, ArrayList�� ��. events�ȿ� �迭�� ������ �������� ������ events�ȿ� �� ����ִ�
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
			if (ev .isRelevant(theDate)) // Event �ȿ��� ����. isRelevant��. dynamic binding��? �װŴ� ������ �ڵ带 ������ �� �߻��ϴ� ��.
												// �����Ϸ��� �� ���� Event�ȿ��� isRelevant�� �����ϱ�.
												// �׷��� events[i].toString��? �װŴ� class Object�� toString�� ������ �����ϱ�. �����Ϸ���
												// �׷��� �Ǵ��Ѵ�. ���������δ� ������ ����. ������ ���α׷��� ����� ���� dynamic binding�� �Ͼ��.
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
