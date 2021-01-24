package week3Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * UC San Diego Data Structures
 * 
 * Heap sort (in place) implemented using Priority Queue (implemented by binary max heap)
 * 
 * Enter size of input array then the elements of the array to be sorted
 * 
 * Running time = O(n log(n)) (n/2 siftDowns * (log(n)->siftDown itself))
 * Asymptotically optimal for comparison-based algorithms
 * 
 * More thorough analysis results in buildHeap running in O(2n) time
 * but that does not refine the sorting algorithm runtime as we 
 * extract max (n-1) times in the sortHeap function
 * 
 * partialSort() can run in O(n) time if k is n/log n maxumum.
 * buildHeap + partialSort = O(2n + k log n)
 * if k == n/log n ==> then the Time = O(n)
 * 
 * It's considered a natural generalization of selection sort O(n2):
 * instead of scanning the rest of the array to find the maximum value,
 * use a smart data structure(binary heap)
 * 
 * In place: no additional data structure
 * data are made binary heap on the fly
 * 
 * @author Mohammed Abdelkawy: January 8, 2021
 */

public class HeapSortInPlace {

	Integer[] A;
	int size;

	class FastScanner {
		StringTokenizer tokenizer = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tokenizer.hasMoreElements()) {
				tokenizer = new StringTokenizer(in.readLine());
			}
			return tokenizer.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	private int leftChild(int i) {
		return 2 * i;
	}

	private int rightChild(int i) {
		return 2 * i + 1;
	}

	private void siftDown(int i) {
		int maxIndex = i;

		int l = leftChild(i);
		if (l <= size&& A[l - 1] > A[maxIndex - 1])
			maxIndex = l;

		int r = rightChild(i);
		if (r <= size && A[r - 1] > A[maxIndex - 1])
			maxIndex = r;

		if (i != maxIndex) {
			swap(i - 1, maxIndex - 1);
			siftDown(maxIndex);
		}
	}

	private void swap(int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	private void buildHeap() { //O(2n)
		for (int i = A.length / 2 + 1; i > 0; i--) {
			siftDown(i);
		}
	}

	/*public int extractMax() {
		//int size = A.length;
		swap(size - 1, 0);
		int max = A[size - 1];
		A[--size] = null;
		siftDown(1);
		return max;
	}*/
	
	private void display(int k) {
		/*for (int i = 0; i < A.length; i++) {
			System.out.print(extractMax() + "\t");
		}*/
		int i = k == 0?0:A.length-k;
		for (; i < A.length; i++) {
			System.out.print(A[i] + "\t");
		}
	}
	
	private void heapSort() {//O(n log n)
		for (int i = 0; i < A.length - 1; i++) { 
			//same as extractMax
			swap(0, --size);
			siftDown(1);
		}
	}
	
	private void partialSort(int k) {//O(k log n)
		for (int i = 0; i < k; i++) { 
			//same as extractMax
			swap(0, --size);
			siftDown(1);
		}
	}

	public void solve() throws IOException {
		FastScanner scanner = new FastScanner();
		size = scanner.nextInt();

		A = new Integer[size];
		
		for (int i = 0; i < A.length; i++) {
			A[i]=  scanner.nextInt();
		}
		
		buildHeap();
		//heapSort();
		//display(0);
		partialSort(4);

		display(4);
	}

	public static void main(String[] args) throws IOException {
		new HeapSortInPlace().solve();
	}

}
