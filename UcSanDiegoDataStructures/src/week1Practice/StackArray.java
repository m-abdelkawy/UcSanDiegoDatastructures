package week1Practice;

public class StackArray<T> {
	T[] s;
	int N = 0;

	public StackArray() {
		s = (T[]) new Object[1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void push(T item) {
		if (N == s.length) {
			resizeArr(2 * s.length);
		}
		s[N++] = item;
	}

	public T top() {
		return s[N - 1];
	}

	public T pop() {
		T item = s[--N];
		s[N] = null;
		if (N > 0 && N == s.length / 4) {
			resizeArr(s.length / 2);
		}
		return item;
	}

	
	
	public void resizeArr(int capacity) {
		T[] temp = (T[])new Object[capacity];

		if (s.length <= capacity) {
			for (int i = 0; i < s.length; i++) {
				temp[i] = s[i];
			}
		} else {
			for (int i = 0; i < temp.length; i++) {
				temp[i] = s[i];
			}
		}
		s = temp;
	}
	
	public void display() {
		for (int i = 0; i < N; i++) {
			System.out.println(s[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackArray<Integer> stack = new StackArray<Integer>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.top());
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		
		stack.display();
	}

}
