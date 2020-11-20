package week1Practice;

public class SinglyLinkedList<T> {
	private Node head;

	// private Node node;
	private class Node {
		public Node(T data) {
			this.data = data;
		}

		private T data;
		private Node next;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void pushFront(T item) {
		System.out.println("pushFront called:---------O(1)----------!");
		Node node = new Node(item);
		if (isEmpty()) {
			head = node;
		} else {
			node.next = head;
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
		return res;
	}

	public void pushBack(T item) {
		System.out.println("pushBack called:---------O(n)-O(1)tailPtr---------!");
		Node node = new Node(item);
		if (isEmpty())
			head = node;
		else {

			Node ptr = head;
			while (ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = node;
		}
	}

	public Node topBack() {
		System.out.println("topBack called:---------O(n)-O(1)tailPtr----------!");
		if (isEmpty()) {
			System.out.println("topBack: List is empty!");
			return null;
		}

		Node ptr = head;
		if (ptr.next == null) {// one element in the list
			return ptr;
		}

		while (ptr.next != null) {
			ptr = ptr.next;
		}
		return ptr;
	}

	public Node popBack() {
		System.out.println("popBack called:---------O(n)----------!");
		if (isEmpty()) {
			System.out.println("popBack: List is empty!");
			return null;
		}

		Node ptr = head;
		if (ptr.next == null) {// one element in the list
			head = null;
			return ptr;
		}

		Node ptrPrev = ptr;
		while (ptr.next != null) {
			ptrPrev = ptr;
			ptr = ptr.next;
		}
		Node res = ptr;
		ptrPrev.next = null;
		return res;
	}

	public Node addAfter(Node node, T item) {
		System.out.println("addAfter called:---------O(1)----------!");
		Node node2 = new Node(item);
		node2.next = node.next;
		node.next = node2;
		return node2;
	}

	public Node addBefore(Node node, T item) {
		System.out.println("addBefore called:---------O(n)----------!");
		Node node2 = new Node(item);
		node2.next = node.next;

		if (node.equals(head)) {
			node2.next = head;
			head = node2;
		} else {
			Node ptr = head;
			Node prev = head;

			while (ptr.next != null) {
				if (ptr.equals(node)) {
					node2.next = ptr;
					prev.next = node2;
				} else {
					prev = ptr;
					ptr = ptr.next;
				}
			}
		}
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
	
	public void erase(T item) {
		System.out.println("erase called:---------O(n)----------!");
		if(isEmpty()) {
			System.out.println("List is empty!");
		}else {
			if(head.data == item) {
				head = head.next;
			}else {
				
				Node ptr = head;
				Node prev = head;
				
				while (ptr.next != null) {
					prev = ptr;
					ptr = ptr.next;
					if (ptr.data == item) {
						prev.next = ptr.next;
						ptr.next = null;
						return;
					}
				}
				System.out.print("Item not found!");
			}
		}
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
		SinglyLinkedList<Integer> lstInt = new SinglyLinkedList<Integer>();
		lstInt.pushFront(5);
		lstInt.pushFront(4);
		lstInt.pushFront(3);
		/*
		 * lstInt.pushFront(4); lstInt.pushFront(3); lstInt.pushFront(2);
		 * 
		 * lstInt.pushBack(7); lstInt.pushBack(8);
		 * 
		 * //System.out.println(lstInt.popBack().data);
		 * //System.out.println(lstInt.popBack().data);
		 * 
		 * lstInt.popBack(); lstInt.popBack();
		 * 
		 * lstInt.pushBack(12);
		 * 
		 * lstInt.popFront(); lstInt.popFront();
		 * 
		 * lstInt.pushFront(17);
		 */

		//System.out.println(lstInt.popFront().data);
		// System.out.println(lstInt.popBack().data);

		lstInt.display();
		lstInt.erase(5);
		lstInt.display();
	}

}
