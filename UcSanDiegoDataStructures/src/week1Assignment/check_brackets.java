//package week1Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Bracket {
	char type;
	int position;

	Bracket(char type, int position) {
		this.type = type;
		this.position = position;
	}

	boolean match(char c) {
		if(this.type == '{' && c == '}') return true;
		if(this.type == '[' && c == ']') return true;
		if(this.type == '(' && c==')')return true;
		return false;
	}
}

class check_brackets {
	public static void main(String[] args) throws IOException {
		InputStreamReader inputStream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(inputStream);
		String txt = reader.readLine();
		
		Stack<Bracket> stackBrackets = new Stack<Bracket>();
		
		for (int pos = 0; pos < txt.length(); pos++) {
			char next = txt.charAt(pos);
			if(next == '[' || next =='{' || next =='(') {
				stackBrackets.push(new Bracket(next, pos));
			}
			else if(next == ']' || next =='}' || next ==')') {
				
				if(stackBrackets.isEmpty() || !stackBrackets.pop().match(next)) {
					System.out.println(pos+1);
					return;
				}
			}
		}
		if(!stackBrackets.isEmpty()) {
			System.out.println(stackBrackets.peek().position+1);
			return;
		}
		
		System.out.println("Success");
	}

}
