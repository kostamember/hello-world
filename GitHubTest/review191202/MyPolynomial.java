package review191202;

import java.util.Scanner;

public class MyPolynomial {

	private Polynomial [] polys = new Polynomial[100];
	int n =0;
	private Scanner kb = new Scanner(System.in);
	public MyPolynomial() {
		
	}
	
	
	private void commandProcessor() {

		
		
		while(true) {
			System.out.print("$ ");
			String command = kb.next();
			if(command.equals("create")) {
				handleCreate();
			} else if(command.equals("add")) {
				handleAdd();
			} else if(command.equals("print")) {
				handlePrint();
			} else if(command.equals("calc")) {
				handleCalc();
			} else if(command.equals("exit")) {
				break;
			}		
		}	
		kb.close();
	}
	
	
	private void handleCalc() {
		char name = kb.next().charAt(0);
		int x = kb.nextInt();
		int index = find(name);
		if(index <= -1) {
			System.out.println("No such polynomial");
			return;
		}
		System.out.println(polys[index].calc(x));
		
	}


	private int find(char name) {
		for(int i=0; i<n; i++) {
			if(polys[i].name == name) {
				return i;
			}
		}
		return -1;
	}


	private void handlePrint() {
		char name = kb.next().charAt(0);
		int index = find(name);
		if(index <= -1) {
			System.out.println("No such polynomial");
			return;
		}
		System.out.println(polys[index].toString());
		
	}


	private void handleAdd() {
		char name = kb.next().charAt(0);
		int coef = kb.nextInt();
		int expo = kb.nextInt();
		
		int index = find(name);
		if(index < -1) {
			System.out.println("No such polynomial");
			return;
		}
		polys[index].addTerm(coef, expo);
		
	}


	private void handleCreate() {
		char name = kb.next().charAt(0);
		// Polynomial��ü�� �����, �������� p�� �װ��� ����Ű���� �����
		Polynomial p = new Polynomial(name);
		// Polynomial �迭�� polys�� p�� ���� �ִ´�
		polys[n++] = p;
		
	}


	public static void main(String[] args) {
		MyPolynomial app = new MyPolynomial();
		app.commandProcessor();
	}

	
}
