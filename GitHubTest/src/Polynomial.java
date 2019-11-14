import java.util.Scanner;

import Section1.Polynomial;

public class Polynomial {

	static PolynomialC [] polys = new PolynomialC[100]; // 다항식의 수
	static int n = 0;
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while(true) {
			System.out.print("$ ");
			
			String command = kb.next();
			if(command.equals("create")) {
				char name =kb.next().charAt(0);
				// 잊지 않고 객체를 만들어주어야 한다
				polys[n] = new PolynomialC();
				
				polys[n].name = name;
				polys[n].terms = new Term[100];
				polys[n].nTerm = 0; // 현재 항의 개수
				
				n++;
			} else if(command.equals("add")) {
				char name = kb.next().charAt(0);
				int index = findIndex(name);			// 그런 이름의 다항식이 있는지 없는지 검사해서 있으면 그 다항식이 몇 번쨰에 있는지 리턴해준다
				
				if(index == -1) {
					System.out.println("No such file like that");
				} else {
					int coef = kb.nextInt();
					int expo = kb.nextInt();
					addTerm(polys[index], coef, expo);  // polys[index] 다항식에 계수 coef, 지수 expo를 갖는 항을 추가하여라.
				}
			} else if(command.equals("calc")) {
				char name = kb.next().charAt(0);
				int index = findIndex(name);			// 그런 이름의 다항식이 있는지 없는지 검사해서 있으면 그 다항식이 몇 번쨰에 있는지 리턴해준다
				
				if(index == -1) {
					System.out.println("No such file like that");
				} else {
					int x = kb.nextInt();
					int result = calcPolynomial(polys[index], x);
					System.out.println(result);
				}
				
				
				
				
			}  else if(command.equals("print")) {
				char name = kb.next().charAt(0);
				int index = findIndex(name);
				if(index == -1) {
					System.out.println("No file like that");
				} else {
					printPolynomial(polys[index]);
				}
			} else if(command.equals("exit")) 
				break;
		
			
			
			
		}	
		kb.close();	
			
			
		}



	private static int calcPolynomial(PolynomialC p, int x) {
		
		int i=0;
		int result = 0;
		for(i=0; i<p.nTerm; i++) {
			int sum = (p.terms[i].coef*(int) Math.pow(x, p.terms[i].expo));
			result = result + sum;
		}
		
		
		
		return result;
	}



	private static void printPolynomial(PolynomialC p) {
		// TODO Auto-generated method stub
		for(int i=0; i<p.nTerm; i++) {
			System.out.print(p.terms[i].coef+"x^"+p.terms[i].expo);
			System.out.print("+");
		}
		System.out.println();
	}



	private static void addTerm(PolynomialC p, int c, int e) {
		// TODO Auto-generated method stub
		int index = findTerm(p, e); // 다항식 p에 계수로 expo를 가지는 항이 있는지 없는지 검사
		
		if(index != -1) {			// -1의 뜻은 입력한 항의 지수와 일치하는 항이 있다는 것
			p.terms[index].coef += c;
		
		} else {
			int i = p.nTerm -1;
			while(i >= 0 && p.terms[i].expo < e) {
				p.terms[i+1] = p.terms[i];
				i--;					
			}
			p.terms[i+1] = new Term();
			p.terms[i+1].coef = c;
			p.terms[i+1].expo = e;
			p.nTerm++;
			
		}
		
		
		
	}

	private static int findTerm(PolynomialC p, int e) {
		// TODO Auto-generated method stub
		for(int i=0; i<p.nTerm && p.terms[i].expo >= 0; i++) 
			if(p.terms[i].expo == 0) 
				return i;
			
		
		return -1;
	}
		


	private static int findIndex(char name) {
		// TODO Auto-generated method stub
		int i = 0;
		for(i=0 ;i<n; i++) {
			if(polys[i].name == name) {  // 이렇게 쓰는게 가능하다. 왜냐하면 char는 문자열이 아니라 문자니까.
				return i;
			}
		}		
		return -1;
	}

	}


