package Scheduler03;

import Scheduler03.MyDate;

public class OneDayEvent extends Event {
	// String title;
	public MyDate date;
	
	public OneDayEvent(String title, MyDate date) {
		super(title);	
		this.date = date;
		
	}
	public boolean isRelevant(MyDate date) {
		
		return this.date.compareTo(date) == 0;
	}
	public MyDate getRepresentativeDate() {
		return date;
	}
	
	public String toString() {
		return title+","+date.toString();
	}

}
