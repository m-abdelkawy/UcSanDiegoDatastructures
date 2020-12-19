package week1Practice;

public class Node<T> {
	T key;
	Node left, right;

	public Node(T item) {
		key = item;
		left = right = null;
	}
}
