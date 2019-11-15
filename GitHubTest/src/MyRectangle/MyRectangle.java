package MyRectangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyRectangle {
	
	static RecInfo [] rec = new RecInfo[100];	// RecInfo 배열 rec을 만들었다. 100개의 사각형을 저장할 수 있다  
	static int n = 0; // 사각형의 개수
	
	public static void main(String[] args) {
		
		try {
			Scanner inFile = new Scanner(new File("input.txt"));
		
			while(inFile.hasNext()) {
				// 객체를 만들고, inFile.nextInt로 수를 받아서 초기화까지 한다
				rec[n] = new RecInfo(inFile.nextInt(), inFile.nextInt(),inFile.nextInt(),inFile.nextInt());		// 여기서 rec[n]의 객체를 만든다. 궁금한 것은 RecInfo 클래스에서 객체를 만들어두었는데, 여기서 rec[n]을 만들면 PointRec의 객체도 자동으로 만들어지는지이다.
		
				/*
				 * rec[n].point.x = inFile.nextInt(); rec[n].point.y = inFile.nextInt();
				 * rec[n].width = inFile.nextInt(); rec[n].height = inFile.nextInt();
				 */
				
				n++;
			}
		
			inFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("No file");
			System.exit(1);
		}
		
		bubbleSort();
		
		for(int i=0; i<n; i++) {
			System.out.println(rec[i].toString());
		}
		
		
	}

	private static void bubbleSort() {
		for(int i=n-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(rec[j].calcArea() > rec[j+1].calcArea()) {
				RecInfo temp = rec[j+1];
				rec[j+1] = rec[j];
				rec[j] = temp;
				}
			}
		}
		
	}


}
