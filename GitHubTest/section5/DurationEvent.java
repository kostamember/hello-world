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
		
		return begin.compareTo(date) <= 0 && end.compareTo(date) >= 0;  // compateTo �޼ҵ�� ���ϰ��� �ϴ°�  �񱳵Ǵ� �ͺ��� ũ�� ����� ��ȯ�Ѵ�.
		
	}
	
	public MyDate getRepresentativeDate() {
		return begin;
	}
	public String toString() {
		return title+","+begin+"~"+end;
	}
}
