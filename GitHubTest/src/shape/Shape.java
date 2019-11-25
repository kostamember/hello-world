package shape;

public abstract class Shape implements MyComparable{
	public String title;
	// �����ڴ� �̸��� ������ �ȴ�
	public Shape(String title) {
		this.title = title;
	}
	// Shape Ŭ������ ��ӹ޴� Ŭ�������� �Ʒ��� �͵��� �����ؾ� �Ѵ�
	public abstract double computeArea();
	public abstract double computePerimeter();
	
	//	�����ִ� ��
	public int compareTo(Object o) {
		double myArea = computeArea();
		double yourArea = ((Shape)o).computeArea();
		if(myArea < yourArea) return -1;
		else if(myArea == yourArea) return 0;
		else return 1;
	}
}
