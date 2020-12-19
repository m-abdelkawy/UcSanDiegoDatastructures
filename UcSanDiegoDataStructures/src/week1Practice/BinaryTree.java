package week1Practice;

/*
 			    5

		4				6
		
	2		3		8		9
  */
public class BinaryTree<T> {
	private Node root;

	public BinaryTree(T key) {
		this.root = new Node(key);
	}

	public int Height(Node node) {
		if (node == null)
			return 0;
		return 1 + Math.max(Height(node.left), Height(node.right));
	}

	public static void inOrderTraversal(Node root) {
		if (root == null)
			return;
		inOrderTraversal(root.left);
		print(root.key);
		inOrderTraversal(root.right);
	}

	public static void preOrderTraversal(Node root) {
		if (root == null)
			return;
		print(root.key);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	public static void postOrderTraversal(Node root) {
		if (root == null)
			return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		print(root.key);
	}

	public static void levelTraversal(Node root) {
		if (root == null)
			return;
		QueueLinkedList<Node> q = new QueueLinkedList<Node>();
		q.enqueue(root);
		Node node = null;
		while (!q.isEmpty()) {
			node = q.dequeue();
			print(node.key);
			if (node.left != null)
				q.enqueue(node.left);
			if (node.right != null)
				q.enqueue(node.right);
		}
	}

	/*public static void levelTraversalRecursive(Node root) {
		if (root == null)
			return;
		print(root.key);
		levelTraversalRecursive(root.left);
		levelTraversalRecursive(root.right);
	}*/

	private static void print(Object key) {
		System.out.print(key + "\t");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> tree = new BinaryTree<Integer>(5);

		tree.root.left = new Node(4);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(3);

		tree.root.right = new Node(6);
		tree.root.right.left = new Node(8);
		tree.root.right.right = new Node(9);


		System.out.println("\nTree Height: ");
		System.out.print(tree.Height(tree.root));
		System.out.println("\nDFS: In Order Traversal: ");
		inOrderTraversal(tree.root);
		System.out.println("\nDFS: Pre Order Traversal: ");
		preOrderTraversal(tree.root);
		System.out.println("\nDFS: Post Order Traversal: ");
		postOrderTraversal(tree.root);
		System.out.println("\nBFS: Level Traversal: ");
		levelTraversal(tree.root);
	}

}
