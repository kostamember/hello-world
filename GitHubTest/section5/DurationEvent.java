package section5;

import section5.MyDate;

public class DurationEvent extends Event{
	//public String title;
	public MyDate begin;
	public MyDate end;
	
	public DurationEvent(String title, MyDate day1, MyDate day2) {
		super(title);
		this.begin = day1;
		this.end = day2;
	}
	public boolean isRelevant(MyDate date) { // begin <= date <= end
		
		return begin.compareTo(date) <= 0 && end.compareTo(date) >= 0;  // compateTo 메소드는 비교하고자 하는게  비교되는 것보다 크면 양수를 반환한다.
		
	}
	
	public MyDate getRepresentativeDate() {
		return begin;
	}
	public String toString() {
		return title+","+begin+"~"+end;
	}
}
