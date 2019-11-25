package shape;

import java.util.Arrays;
import java.util.Scanner;

public class ShapeApplication {

	public int capacity = 10;
	public Shape [] shapes = new Shape[capacity];
	public int n =0;
	public Scanner kb = new Scanner(System.in);
	
	
	public void commandProcessor() {
		while(true) {
			System.out.print("$ ");
			String command = kb.next();
			if(command.equals("add")) {
				handleAdd();
			} else if(command.equals("show") || command.equals("showdetail")) {
				handleShow(command.equals("showdetail"));
			} else if(command.equals("sort")) {
				Arrays.sort(shapes, 0, n);
			} else if(command.equals("exit")) {
				break;
			}
		}
		
	}
	
	
	private void handleShow(boolean detailed) {
		for(int i=0; i<n; i++) {
			System.out.println((i+1)+". "+shapes[i].toString());
			if(detailed) {
				System.out.println("Area is "+shapes[i].computeArea());
				System.out.println("Perimeter is "+shapes[i].computePerimeter());
			}
		}
		
	}




	private void handleAdd() {
		String type = kb.next();
		switch(type) {
		case "R":
			addShape(new Rectangle(kb.nextInt(), kb.nextInt()));
			break;
		case "C":
			addShape(new Circle(kb.nextInt()));
			break;
		case "T":
			
		
		}
			
		
	}




	private void addShape(Shape shape) {
		if(n>= capacity) 
			reallocate();
		
		shapes[n++] = shape;
	}


	private void reallocate() {
		Shape [] temp = new Shape[capacity*2];
		for(int i=0; i<n; i++) {
			temp[i] = shapes[i];
		}
		shapes = temp;
		capacity *= 2;
		
	}


	public static void main(String[] args) {
		ShapeApplication app = new ShapeApplication();
		app.commandProcessor();
	}
}
