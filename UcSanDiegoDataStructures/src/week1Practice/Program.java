package week1Practice;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isBalanced("([()])"));
	}

	public static boolean isBalanced(String str) {
		StackLinkedList<Character> stack = new StackLinkedList<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '[' || str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			} else {
				if (stack.isEmpty())
					return false;
				char top = stack.pop();
				if ((top == '[' && str.charAt(i) != ']') || (top == '(' && str.charAt(i) != ')'))
					return false;
			}
		}

		return stack.isEmpty();
	}
}
