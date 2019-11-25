package shape;

public class Circle extends Shape{

	public int radius;

	public Circle(int radius) {
		super("Circle");
		this.radius = radius;
	}
	

	public double computeArea() {
		return Math.PI*radius*radius;
	}

	public double computePerimeter() {
		return 2*Math.PI*radius;
	}
	
	public String toString() {
		return "The circle radius is "+radius;
	}
	
}
