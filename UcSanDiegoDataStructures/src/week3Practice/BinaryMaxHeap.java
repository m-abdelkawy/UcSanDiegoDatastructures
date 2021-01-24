package week3Practice;

/**
 * UC San Diego Data Structures
 * 
 * Priority Queue implemented by binary max heap
 * 
 * All operations work in time O(log(n)) getMax work in O(1)
 * 
 * @author : January 17, 2021
 */

public class BinaryMaxHeap {
	private int size;
	private int capacity;
	private Integer[] heap;
	private int rootIndex = 0;

	public BinaryMaxHeap(int _capacity) {
		capacity = _capacity;
		heap = new Integer[capacity];
	}

	private int parent(int i) {
		return (int) Math.ceil(Double.valueOf(i) / 2) - 1;
	}

	private int leftChild(int i) {
		return 2 * i + 1;
	}

	private int rightChild(int i) {
		return 2 * i + 2;
	}

	private void siftUp(int i) {
		while (i > 0 && heap[i] > heap[parent(i)]) {
			swap(i, parent(i));
			i = parent(i);
		}
	}

	private void siftDown(int i) {
		int maxIndex = i;

		int l = leftChild(i);
		if (l < size && heap[l] > heap[maxIndex])
			maxIndex = l;

		int r = rightChild(i);
		if (r < size && heap[r] > heap[maxIndex])
			maxIndex = r;

		if (i != maxIndex) {
			swap(i, maxIndex);
			siftDown(maxIndex);
		}
	}

	public boolean insert(int p) {
		if (size == capacity)
			return false;
		heap[size++] = p;
		siftUp(size-1);
		return true;
	}

	private boolean remove(int i) {
		if (size < 1)
			return false;

		heap[i] = Integer.MAX_VALUE;

		siftUp(i);

		extractMax();

		return true;
	}

	public int extractMax() {
		int result = heap[rootIndex];
		swap(rootIndex, size -1);
		heap[size-1]=null;
		size--;
		siftDown(rootIndex);
		return result;
	}

	private void changePriority(int i, int p) {
		int oldP = heap[i];
		heap[i] = p;
		if (oldP > p)
			siftDown(i);
		else if (oldP < p)
			siftUp(i);
	}

	private int getMax() {
		return heap[rootIndex];
	}

	private void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	private void display() {
		if (size == 0)
			System.out.println("Heap is Empty");

		else {
			int j = 1; // number of elements in level
			int i = 0; // index in array
			int pow = 0; // level index
			while (i < size) {
				j = (int) Math.pow(2, pow++);
				int k = 0;
				for (; k < j; k++) {
					if (heap[i + k] != null)
						System.out.print(heap[i + k] + "\t");
				}
				System.out.println();
				i += k;
			}
		}

	}

	/*public static void main(String[] args) {
		BinaryMaxHeap binaryHeap = new BinaryMaxHeap(10);

		binaryHeap.insert(5);
		binaryHeap.insert(10);
		binaryHeap.insert(1);
		binaryHeap.insert(7);

		binaryHeap.display();
	}*/
}
