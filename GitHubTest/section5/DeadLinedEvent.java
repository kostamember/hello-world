package section5;

import section5.MyDate;

public class DeadLinedEvent extends Event {
	//public String title;
	public MyDate deadline;
	
	public DeadLinedEvent(String title, MyDate e) {
		//this.title = title;
		super(title);
		this.deadline = e;
	}
	public boolean isRelevant(MyDate date) {
		return deadline.compareTo(date) >= 0;
	}
	public MyDate getRepresentativeDate() {
		return deadline;
	}
	
	public String toString() {
		return title+","+deadline;
	}
}
