package week1Practice;

public class StackLinkedList<T> {
	Node head;
	//int N = 0;

	private class Node {
		private T item;
		private Node next;

		public Node(T item) {
			this.item = item;
		}
	}

	public boolean isEmpty() {
		// return N == 0;
		return head == null;
	}

	public void push(T item) {
		Node node = new Node(item);
		node.next = head;
		head = node;

		/*
		 * if (isEmpty()) { head = node; } else { node.next = head; head = node; } N++;
		 */
	}

	public T top() {
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			return null;
		} else
			return head.item;
	}

	public T pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			return null;
		} else {
			T res = head.item;
			head = head.next;
			return res;
		}
		/*
		 * if (isEmpty()) { System.out.println("Stack is empty!"); return null; } else {
		 * N--; Node res = head; head = head.next; return res.item; }
		 */
	}

	public void display() {
		Node ptr = head;
		while (ptr != null) {
			System.out.println(ptr.item);
			ptr = ptr.next;
		}
		/*
		 * if (isEmpty()) { return; } Node ptr = head; do {
		 * System.out.println(ptr.item); ptr = ptr.next; } while (ptr != null);
		 */
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackLinkedList<Integer> stack = new StackLinkedList<Integer>();
		stack.push(5);
		stack.push(7);
		stack.push(8);

		// System.out.println(stack.top());
		/*
		 * stack.pop(); stack.pop(); stack.pop(); stack.pop();
		 */
		stack.pop();
		stack.pop();
		stack.display();
	}

}
