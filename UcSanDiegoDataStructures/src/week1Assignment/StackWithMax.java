
//package week1Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackWithMax {

	Stack<Integer> trackStack = new Stack<Integer>();

	class FastScanner {
		StringTokenizer tokenizer = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tokenizer.hasMoreElements()) {
				tokenizer = new StringTokenizer(in.readLine());
			}
			return tokenizer.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public void solve() throws IOException {
		FastScanner scanner = new FastScanner();
		int nquery = scanner.nextInt();

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < nquery; i++) {
			String operation = scanner.next();
			if (operation.equals("push")) {
				int tok = scanner.nextInt();

				stack.push(tok);

				if (!trackStack.isEmpty() && tok < trackStack.peek()) {
					
					trackStack.push(trackStack.peek());

				} else {
					trackStack.push(tok);
				}
			} else if (operation.equals("pop")) {
				trackStack.pop();
				stack.pop();

			} else if (operation.equals("max"))
				System.out.println(trackStack.peek());
		}
	}

	public static void main(String[] args) throws IOException {
		new StackWithMax().solve();
	}

}
