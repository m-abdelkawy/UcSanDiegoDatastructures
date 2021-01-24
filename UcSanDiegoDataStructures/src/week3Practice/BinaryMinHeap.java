package week3Practice;

import week3Practice.BuildHeap.Swap;

/**
 * UC San Diego Data Structures
 * 
 * Priority Queue implemented by binary minimum heap
 * 
 * All operations work in time O(log(n)) getMin work in O(1)
 * 
 * @author Mohammed Abdelkawy: TODO
 */

public class BinaryMinHeap {
	private int capacity;
	private int size;
	private int rootIndex = 0;
	private Integer[] heap;

	public BinaryMinHeap(int capacity) {
		this.capacity = capacity;
		heap = new Integer[capacity];
	}

	int parent(int i) {
		return (int)Math.ceil(Double.valueOf(i) / 2) - 1;
	}

	int leftChild(int i) {
		return 2 * i + 1;
	}

	int rightChild(int i) {
		return 2 * i + 2;
	}

	void siftUp(int i) {
		while (i > rootIndex && heap[parent(i)] > heap[i]) {
			swap(parent(i), i);
			i = parent(i);
		}
	}

	void siftDown(int i) {
		int minIndex = i;

		int l = leftChild(i);
		if (l <= size-1 && heap[l] < heap[minIndex]) {
			minIndex = l;
		}

		int r = rightChild(i);
		if (r <= size-1 && heap[r] < heap[minIndex]) {
			minIndex = r;
		}

		if (i != minIndex) {
			swap(minIndex, i);
			siftDown(minIndex);
		}
	}

	boolean insert(int p) {
		if (size == capacity)
			return false;
		heap[size++] = p;
		siftUp(size - 1);
		return true;
	}

	int remove(int i) {
		heap[i] = Integer.MIN_VALUE;
		siftUp(i);
		return extractMin();
	}

	void changePriority(int i, int p) {
		int old_p = heap[i];
		heap[i] = p;
		if (old_p < p) {
			siftDown(i);
		} else if (old_p > p) {
			siftUp(i);
		}

	}

	int getMin() {
		return heap[rootIndex];
	}

	int extractMin() {
		int result = heap[rootIndex];
		swap(rootIndex, size -1);
		heap[size-1]=null;
		size--;
		siftDown(rootIndex);
		return result;
	}

	void swap(int i, int j) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryMinHeap binaryHeap = new BinaryMinHeap(10);

		binaryHeap.insert(5);
		binaryHeap.insert(10);
		binaryHeap.insert(1);
		binaryHeap.insert(7);
		binaryHeap.insert(-2);
		binaryHeap.insert(3);
		binaryHeap.remove(2);
		
		binaryHeap.extractMin();

		binaryHeap.display();
	}

}
