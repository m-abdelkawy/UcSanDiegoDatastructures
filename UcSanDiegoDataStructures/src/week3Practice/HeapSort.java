package week3Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * UC San Diego Data Structures
 * 
 * Heap sort implemented using Priority Queue (implemented by binary max heap)
 * 
 * Enter size of input array then the elements of the array to be sorted
 * 
 * Running time = O(n log(n))
 * Asymptotically optimal for comparison-based algorithms
 * 
 * It's considered a natural generalization of selection sort O(n2):
 * instead of scanning the rest of the array to find the maximum value,
 * use a smart data structure(binary heap)
 * 
 * It uses additional space to store the priority queue
 * 
 * @author Mohammed Abdelkawy: January 8, 2021
 */

public class HeapSort {
	BinaryMaxHeap heap;
	int[] A;

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
	
	private void displaySorted() {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]+"\t");
		}
	}

	public void solve() throws IOException {
		FastScanner scanner = new FastScanner();
		int size = scanner.nextInt();

		A = new int[size];
		heap = new BinaryMaxHeap(size);
		for (int i = 0; i < size; i++) {
			heap.insert(scanner.nextInt());
		}
		
		for (int i = size - 1; i >= 0; i--) {
			A[i]= heap.extractMax();
		}
		
		displaySorted();
	}

	public static void main(String[] args) throws IOException {
		new HeapSort().solve();
	}

}