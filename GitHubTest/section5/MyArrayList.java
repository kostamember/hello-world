package section5;

import java.util.Arrays;
import java.util.Scanner;

public class MyArrayList<E> {		// E라는 타입의 데이터가 있다고 가정한다.
	// E타입의 데이터를 여러 개 보관할 수 있어야 한다
	private static final int INIT_CAPACITY = 10;
	private E [] theDate;	
	private int size; //  실제 배열의 크기
	private int capacity = 0;
	private static Scanner kb = new Scanner(System.in);
	

	public MyArrayList() {
		// 생성자 안에서 배열의 객체를 만든다
		// theDate = new E[INIT_CAPACITY]; -> 이렇게 하는게 맞아 보이는데, 그렇지 않다. new 연산자 다음에 가짜 타입명이 들어가서는 안 된다.
		
		theDate = (E []) new Object[INIT_CAPACITY];	// Object 타입으로 객체를 만들고, E로 타입 변환을 해 주는게 가장 간단하다
		size = 0;
		capacity = INIT_CAPACITY;
		
	}
	// add 메소드는 두 개가 있어야 한다. 매개변수를 하나 받는것과 두 개 받는것
	public void add(int index, E anEntry) { 
		// 일단 index자리를 기준으로 전부 뒤로 한 칸씩 뒤로 shift시켜야 한다.
		// index부터 size-1까지
		if(index < 0 || index > size) // 배열의 유효한 범위는 o부터 size까지이다
			throw new ArrayIndexOutOfBoundsException(index);	// add를 호출할 때, try-catch를 함
			//	return; // 오류 또는 예외. 이런 경우 프로그램은 아무런 반응도 하지 않고, 그냥 리턴해 버리는.
			
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
		theDate = Arrays.copyOf(theDate, capacity); // 라이브러리가 제공해주는 것으로 memory reallocation을 간단하게 할 수 있다.
		/*
		 * E [] tmp = (E []) new Object[INIT_CAPACITY*2];
		 */
		/*
		 * for(int i=0; i<size; i++) { tmp[i] = theDate[i]; }
		 */
	 
	}
	public void add(E anEntry) {
		add(size, anEntry); // 굳이 여기에 또 add 메소드를 구현할 거 없다. 어차피 size는 마지막이니까. 마지막에 넣어라.
	}
	
	public void show() {
		for(int i=0; i<size; i++) {
			System.out.println(theDate[i]);
		}
	}
	public int size() {
		return size;		// 데이터의 개수를 리턴해주는것
	}
	
	public int indexOf(E anEntry) {
		for(int i=0; i<size; i++) 
			if(theDate[i].equals(anEntry))	// 자바에서는 어떤 타입이든, 심지어 가상의 E 타입이라 하더라도, equals 메소드를 가지고 있다. equals는 Object가 가지고 있는거니까. 
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
		return oldValue; // 부가적인 서비스를 하나 제공한다. 덮어쓰여질 index에 있던 데이터를 리턴해 준다.
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
		return returnValue; // 역시 부가적인 기능. 삭제된 데이터를 리턴해준다. 
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
