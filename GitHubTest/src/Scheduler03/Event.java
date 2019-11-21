package Scheduler03;



public abstract class Event implements Comparable {
	public String title;
	
	public Event(String title) {
		this.title = title;
	}
	
	public abstract boolean isRelevant(MyDate date);
	public abstract MyDate getRepresentativeDate();
	
	public int compareTo(Object other) { // Comparable이 요구하는 메서드가 compareTo임
		// 무엇이 대표값인지 정의하고, 비교한다.
		MyDate mine = getRepresentativeDate();
		MyDate yours = ((Event)other).getRepresentativeDate();
		return mine.compareTo(yours);
	}
}
