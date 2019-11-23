package makeIndex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class makeIndex {
	
	static String [] words = new String[10000];
	static int [] counts = new int[10000];
	static int n = 0;
	static Scanner kb = new Scanner(System.in);
	
	
	public void commandProcessor() {
		while(true) {
			System.out.print("$ ");
			String command =kb.next();
			
			if(command.equals("read")) {
				handleRead();
			} else if(command.equals("list")) {
				handleList();
			} else if(command.equals("saveas")) {
				handleSaveas();
			} else if(command.equals("find")) {
				handleFind();
			} else if(command.equals("exit")) {
				break;
			}
		}
	}
	private void handleSaveas() {
		String saveFile = kb.next();
		try {
			PrintWriter out = new PrintWriter(new FileWriter(saveFile));
			for(int i=0; i<n; i++) {
				out.println(words[i]+", "+counts[i]);
				
			}
			out.close();
		} catch (IOException e) {
			System.out.println("Save Failed");
			return;
		}
	}
	private void handleFind() {
		String findName = kb.next();
		int index = findWord(findName);
		System.out.println(words[index]+", "+counts[index]);
	}

	private void handleList() {
		for(int i=0; i<n; i++) {
			System.out.println(words[i]+", "+counts[i]);
		}
		
	}
	private void handleRead() {
		String FileName = kb.next();
		try {
			Scanner inFile = new Scanner(new File(FileName));
			
			while(inFile.hasNext()) {		// 파일의 끝까지 읽어라.
				String str =inFile.next();
				
				addWord(str);
			}
			inFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("No file");
		}
		
	}
	private void addWord(String str) {	// 여기서 배열에 넣어준다
		int index = findWord(str);		// str이 이미 있는 단어라면 그 인덱스를 , 없는 단어라면 -1을 넣어준다
		if(index != -1) {
			counts[index] += 1;
			return;
		}	
		words[n] = str;
		counts[n] = 1;
		
		n++;
	}
	private int findWord(String str) {
		for(int i=0; i<n; i++) {
			if(words[i].equalsIgnoreCase(str)) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		makeIndex app = new makeIndex();
		app.commandProcessor();
	}
	
}
