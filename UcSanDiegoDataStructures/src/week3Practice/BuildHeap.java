package week3Practice;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BuildHeap {

	private int[] data;
	private ArrayList<Swap> lstSwap;

	private FastScanner scanner;
	private PrintWriter out;

	private int parent(int i) {
		return i / 2 - 1;
	}

	private int leftChild(int i) {
		return i * 2 + 1;
	}

	private int rightChild(int i) {
		return i * 2 + 2;
	}

	private void siftDown(int i) {
		int maxIndex = i;

		int l = leftChild(i);
		if (l <= data.length - 1 && data[l] < data[maxIndex]) {
			maxIndex = l;
		}

		int r = rightChild(i);
		if (r <= data.length - 1 && data[r] < data[maxIndex]) {
			maxIndex = r;
		}

		if (i != maxIndex) {
			generateSwap(i, maxIndex);
			siftDown(maxIndex);
		}
	}

	private void readData() throws IOException {
		int n = scanner.nextInt();
		data = new int[n];
		for (int i = 0; i < data.length; i++) {
			data[i] = scanner.nextInt();
		}
	}

	private void writeResponse() {
		out.println(lstSwap.size());
		for (Swap swap : lstSwap) {
			out.println(swap.index1 + " " + swap.index2);
		}
	}

	private void generateSwap(int i, int j) {
		lstSwap = lstSwap == null ? new ArrayList<Swap>() : lstSwap;
		lstSwap.add(new Swap(i, j));

		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public void solve() throws IOException {
		scanner = new FastScanner();
		BufferedOutputStream outputStream = new BufferedOutputStream(System.out);
		out = new PrintWriter(outputStream);

		readData();
		for (int i = 0; i < data.length; i++) {
			siftDown(i);
		}
		writeResponse();
		out.close();
	}

	static class Swap {
		int index1;
		int index2;

		public Swap(int index1, int index2) {
			this.index1 = index1;
			this.index2 = index2;
		}
	}

	static class FastScanner {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public FastScanner() {
			InputStreamReader streamReader = new InputStreamReader(System.in);
			reader = new BufferedReader(streamReader);
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

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new BuildHeap().solve();
	}

}
