package MyRectangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyRectangle {
	
	static RecInfo [] rec = new RecInfo[100];	// RecInfo �迭 rec�� �������. 100���� �簢���� ������ �� �ִ�  
	static int n = 0; // �簢���� ����
	
	public static void main(String[] args) {
		
		try {
			Scanner inFile = new Scanner(new File("input.txt"));
		
			while(inFile.hasNext()) {
				// ��ü�� �����, inFile.nextInt�� ���� �޾Ƽ� �ʱ�ȭ���� �Ѵ�
				rec[n] = new RecInfo(inFile.nextInt(), inFile.nextInt(),inFile.nextInt(),inFile.nextInt());		// ���⼭ rec[n]�� ��ü�� �����. �ñ��� ���� RecInfo Ŭ�������� ��ü�� �����ξ��µ�, ���⼭ rec[n]�� ����� PointRec�� ��ü�� �ڵ����� ������������̴�.
		
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
