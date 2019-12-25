package lecture01;

public class Recursion01 {

	public static void main(String[] args) {
		func(4);

	}

	private static void func(int k) {
		if(k <=0) 
			return;
		else {
			System.out.println("Hello world");
			func(k-1); 
		}
		
	}

}
