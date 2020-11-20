package week1Practice;

import week1Practice.SinglyLinkedList.Node;

public class DoublyLinkedList<T> {
	private Node head;
	private Node tail;

	// private Node node;
	private class Node {
		private T data;

		private Node prev;
		private Node next;

		public Node(T item) {
			this.data = item;
			// this.prev = null;
		}
	}

	public boolean isEmpty() {
		return head == null && tail == null;
	}

	public void pushFront(T item) {
		System.out.println("pushFront called:---------O(1)----------!");
		Node node = new Node(item);
		if (isEmpty()) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			// head.prev = node;
			head = node;
		}
	}

	public Node topFront() {
		System.out.println("topFront called:----------O(1)---------!");
		if (isEmpty()) {
			System.out.println("topFront: List is empty!");
			return null;
		}
		return head;
	}

	public Node popFront() {
		System.out.println("popFront called:----------O(1)---------!");
		if (isEmpty()) {
			System.out.println("popFront: List is empty!");
			return null;
		}
		Node res = head;
		head = head.next;

		if (head == null)
			tail = null;
		else
			head.prev = null;
		// head.next.prev = head;
		return res;
	}

	public void pushBack(T item) {
		System.out.println("pushBack called:---------O(n)-O(1)tailPtr---------!");
		Node node = new Node(item);
		if (isEmpty()) {
			head = node;
			tail = node;
		} else {

			tail.next = node;
			node.prev = tail;
			tail = node;
		}
	}

	public Node topBack() {
		System.out.println("topBack called:---------O(n)-O(1)tailPtr----------!");
		if (isEmpty()) {
			System.out.println("topBack: List is empty!");
			return null;
		}
		return tail;
	}

	public Node popBack() {
		System.out.println("popBack called:---------O(n)----------!");
		if (isEmpty()) {
			System.out.println("popBack: List is empty!");
			return null;
		} else {
			Node res = tail;

			tail = tail.prev;

			if (tail == null)
				head = null;
			else
				tail.next = null;
			return res;
		}
	}

	public Node addAfter(Node node, T item) {
		System.out.println("addAfter called:---------O(1)----------!");
		Node node2 = new Node(item);
		node2.next = node.next;
		node2.prev = node;
		node.next = node2;
		return node2;
	}

	public Node addBefore(Node node, T item) {
		System.out.println("addBefore called:---------O(n)----------!");
		Node node2 = new Node(item);
		node2.next = node.next;
		node2.prev = node.prev;
		node.prev = node2;
		return node2;
	}
	
	public Node find(T item) {
		System.out.println("display called:---------O(n)----------!");
		if(head.data == item) {
			return head;
		}
		Node ptr = head;
		while(ptr.next != null) {
			ptr = ptr.next;
			if(ptr.data == item)
				return ptr;
		}
		System.out.print("Item not found!");
		return null;
	}

	public void display() {
		System.out.println("display called:-------------------!");
		Node ptr = head;
		if (ptr == null) {
			System.out.println("List is empty!");
			return;
		}
		while (ptr.next != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
		System.out.println(ptr.data);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList<Integer> lstInt = new DoublyLinkedList<Integer>();
		lstInt.pushFront(5);
		lstInt.pushFront(4);
		lstInt.pushFront(3);

		lstInt.display();

		System.out.println(lstInt.topFront().data);
		System.out.println(lstInt.popFront().data);
		System.out.println(lstInt.popFront().data);
		System.out.println(lstInt.popFront().data);
		lstInt.popFront();

		lstInt.display();
	}

}
