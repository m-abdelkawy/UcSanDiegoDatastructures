//package week3Assignment;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
	private int[] data;
	private List<Swap> lstSwap;

	private FastScanner in;
	private PrintWriter out;

	static class FastScanner {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
		}

		public String next() throws IOException {
			while (tokenizer == null || !tokenizer.hasMoreElements()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	static class Swap {
		int index1;
		int index2;

		public Swap(int _index1, int _index2) {
			index1 = _index1;
			index2 = _index2;
		}
	}

	private void readData() throws IOException {
		int n = in.nextInt();
		data = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = in.nextInt();
		}
	}

	private void writeResponse() {
		out.println(lstSwap.size());
		for (Swap swap : lstSwap) {
			out.println(swap.index1 + " " + swap.index2);
		}
	}

	private void generateSwaps() {
		lstSwap = new ArrayList<Swap>();

		for (int i = 0; i < data.length; i++) {
			siftDown(i);
			siftUp(i);
		}
	}

	void siftDown(int i) {// O(logn)
		int minIndex = i;

		int l = leftChild(i);
		if (l <= data.length - 1 && data[l] < data[minIndex]) {
			minIndex = l;
		}

		int r = rightChild(i);
		if (r <= data.length - 1 && data[r] < data[minIndex]) {
			minIndex = r;
		}

		if (i != minIndex) {
			swap(minIndex, i);
			siftDown(minIndex);
		}
	}
	
	void siftUp(int i) {
		while (i > 0 && data[parent(i)] > data[i]) {
			swap(parent(i), i);
			i = parent(i);
		}
	}

	void swap(int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;

		lstSwap.add(new Swap(i, j));
	}

	int parent(int i) {
		return (int) Math.ceil(Double.valueOf(i) / 2) - 1;
	}

	int leftChild(int i) {
		return 2 * i + 1;
	}

	int rightChild(int i) {
		return 2 * i + 2;
	}

	private void solve() throws IOException {
		in = new FastScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		readData();
		generateSwaps();
		writeResponse();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new BuildHeap().solve();
	}

}
