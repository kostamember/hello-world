package shape;

public abstract class Shape implements Comparable{
	public String title;
	// 생성자는 이름만 있으면 된다
	public Shape(String title) {
		this.title = title;
	}
	// Shape 클래스를 상속받는 클래스들은 아래의 것들을 구현해야 한다
	public abstract double computeArea();
	public abstract double computePerimeter();
	
	//	비교해주는 것
	public int compareTo(Object other) {
		double myArea = computeArea();
		double yourArea = ((Shape)other).computeArea();  // (Shape)로 형 변화을 해 주어야 한다. 왜냐하면 Object 타입에는 computeArea가 없으니까.
		if(myArea < yourArea) return -1;
		else if(myArea == yourArea ) return 0;
		else return 1;
				
	}
}
