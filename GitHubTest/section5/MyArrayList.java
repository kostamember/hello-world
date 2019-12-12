package section5;

import java.util.Arrays;
import java.util.Scanner;

public class MyArrayList<E> {		// E��� Ÿ���� �����Ͱ� �ִٰ� �����Ѵ�.
	// EŸ���� �����͸� ���� �� ������ �� �־�� �Ѵ�
	private static final int INIT_CAPACITY = 10;
	private E [] theDate;	
	private int size; //  ���� �迭�� ũ��
	private int capacity = 0;
	private static Scanner kb = new Scanner(System.in);
	

	public MyArrayList() {
		// ������ �ȿ��� �迭�� ��ü�� �����
		// theDate = new E[INIT_CAPACITY]; -> �̷��� �ϴ°� �¾� ���̴µ�, �׷��� �ʴ�. new ������ ������ ��¥ Ÿ�Ը��� ������ �� �ȴ�.
		
		theDate = (E []) new Object[INIT_CAPACITY];	// Object Ÿ������ ��ü�� �����, E�� Ÿ�� ��ȯ�� �� �ִ°� ���� �����ϴ�
		size = 0;
		capacity = INIT_CAPACITY;
		
	}
	// add �޼ҵ�� �� ���� �־�� �Ѵ�. �Ű������� �ϳ� �޴°Ͱ� �� �� �޴°�
	public void add(int index, E anEntry) { 
		// �ϴ� index�ڸ��� �������� ���� �ڷ� �� ĭ�� �ڷ� shift���Ѿ� �Ѵ�.
		// index���� size-1����
		if(index < 0 || index > size) // �迭�� ��ȿ�� ������ o���� size�����̴�
			throw new ArrayIndexOutOfBoundsException(index);	// add�� ȣ���� ��, try-catch�� ��
			//	return; // ���� �Ǵ� ����. �̷� ��� ���α׷��� �ƹ��� ������ ���� �ʰ�, �׳� ������ ������.
			
		if(size >= capacity) 
			reallocate();
		for(int i=size-1; i>=index; i--) {
			theDate[i+1] = theDate[i]; 
		}
		theDate[index] = anEntry;
		size++;
	}
	
	private void reallocate() {
		// TODO Auto-generated method stub
		capacity *=2;
		theDate = Arrays.copyOf(theDate, capacity); // ���̺귯���� �������ִ� ������ memory reallocation�� �����ϰ� �� �� �ִ�.
		/*
		 * E [] tmp = (E []) new Object[INIT_CAPACITY*2];
		 */
		/*
		 * for(int i=0; i<size; i++) { tmp[i] = theDate[i]; }
		 */
	 
	}
	public void add(E anEntry) {
		add(size, anEntry); // ���� ���⿡ �� add �޼ҵ带 ������ �� ����. ������ size�� �������̴ϱ�. �������� �־��.
	}
	
	public void show() {
		for(int i=0; i<size; i++) {
			System.out.println(theDate[i]);
		}
	}
	public int size() {
		return size;		// �������� ������ �������ִ°�
	}
	
	public int indexOf(E anEntry) {
		for(int i=0; i<size; i++) 
			if(theDate[i].equals(anEntry))	// �ڹٿ����� � Ÿ���̵�, ������ ������ E Ÿ���̶� �ϴ���, equals �޼ҵ带 ������ �ִ�. equals�� Object�� ������ �ִ°Ŵϱ�. 
				return i;
		return -1;
		
	}
	public E get (int index) {
		if(index <0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return theDate[index];
	}
	public E set(int index, E newValue) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E oldValue = theDate[index];
		theDate[index] = newValue;
		return oldValue; // �ΰ����� ���񽺸� �ϳ� �����Ѵ�. ������� index�� �ִ� �����͸� ������ �ش�.
	}
	
	public E remove(int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E returnValue = theDate[index];
		for(int i=index+1; i<size; i++) {
			theDate[i-1] = theDate[i];
		}
		size--;
		return returnValue; // ���� �ΰ����� ���. ������ �����͸� �������ش�. 
	}
	
	public static void main(String[] args) {
		MyArrayList<String> test = new MyArrayList<>();
		try {
			while(true) {
			System.out.print("$ ");
			String command = kb.next();
				if(command.equals("add")) {
					String str = kb.next();
					test.add(str);
				} else if(command.equals("show")) {
					test.show();
				} else if(command.equals("size")) {
					int size = test.size();
					System.out.println(size);
				} else if(command.equals("indexof")) {
					String str = kb.next();
					int index =test.indexOf(str);
					System.out.println(index);
				} else if(command.equals("get")) {
					int i = kb.nextInt();
					System.out.println(test.get(i));	
				} else if(command.equals("set")) {
					int index = kb.nextInt();
					String str = kb.next();
					test.set(index, str);
				} else if(command.equals("remove")) {
					int index = kb.nextInt();
					test.remove(index);
				} else if(command.equals("exit")) { 
					break;
				}
				
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
}
