
public class DeadLinedEvent extends Event {
	//public String title;
	public MyDate end;
	
	public DeadLinedEvent(String title, MyDate e) {
		//this.title = title;
		super(title);
		this.end = e;
	}
	
	public String toString() {
		return title+","+end;
	}
}
