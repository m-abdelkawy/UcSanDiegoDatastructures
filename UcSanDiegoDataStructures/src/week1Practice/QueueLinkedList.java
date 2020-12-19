package week1Practice;


public class QueueLinkedList<T> {// FIFO
	Node head, tail;

	private class Node {
		private T item;
		private Node next;

		public Node(T _item) {
			item = _item;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void enqueue(T item) {
		Node node = new Node(item);
		if (isEmpty()) {
			head = node;
			tail = head;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	public T dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
			return null;
		}
		T res = head.item;
		head = head.next;
		if (isEmpty())
			tail = null;
		return res;
	}

	public void display() {
		Node ptr = head;
		while (ptr != null) {
			System.out.println(ptr.item);
			ptr = ptr.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueLinkedList<Integer> q = new QueueLinkedList<Integer>();
		q.enqueue(5);
		q.enqueue(7);
		q.enqueue(2);
		
		//System.out.println(q.dequeue());
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		
		q.display();
	}

}
