package shape;

public abstract class Shape implements MyComparable{
	public String title;
	// 생성자는 이름만 있으면 된다
	public Shape(String title) {
		this.title = title;
	}
	// Shape 클래스를 상속받는 클래스들은 아래의 것들을 구현해야 한다
	public abstract double computeArea();
	public abstract double computePerimeter();
	
	//	비교해주는 것
	public int compareTo(Object o) {
		double myArea = computeArea();
		double yourArea = ((Shape)o).computeArea();
		if(myArea < yourArea) return -1;
		else if(myArea == yourArea) return 0;
		else return 1;
	}
}
