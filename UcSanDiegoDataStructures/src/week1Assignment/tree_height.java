//package week1Assignment;

import java.io.*;
import java.util.*;

public class tree_height {
	class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements()) {
				tok = new StringTokenizer(in.readLine());
			}
			return tok.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int parent[];
		int heights[];

		void read() throws IOException {
			FastScanner fS = new FastScanner();
			n = fS.nextInt();
			parent = new int[n];
			heights = new int[n];
			for (int i = 0; i < parent.length; i++) {
				parent[i] = fS.nextInt();

			}
		}

		int computeHeightOld() throws IOException {
			int maxHeight = 0;
			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				//System.out.print("Vertex: " + vertex + "\t");
				for (int i = 0; i != -1; i = parent[i]) {

					height++;
					//System.out.print("i: " + i + ", val: " + parent[i] + "\t");
					//System.out.print("Height: " + height + "\t");
				}
				//System.out.println();
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;
		}

		int depth(int node_id) throws IOException {
			//System.out.println("depth called - node ID: " + node_id + "    Node value(parent): " + parent[node_id]);
			
			
			//System.out.println();

			if (parent[node_id] == -1) {// base case
				heights[node_id] = 1;
				//System.out.println("Heights: ");
				//display(heights);
				return 1;
			}
			if (heights[node_id] != 0) {
				//System.out.println("Heights: ");
				//display(heights);
				return heights[node_id];
			}
			heights[node_id] = 1 + depth(parent[node_id]);
			//System.out.println("Heights: ");
			//display(heights);
			return heights[node_id];
		}

		int computeHeight() throws IOException {
			int maxHeight = 0;
			for (int i = 0; i < n; i++) {
				//System.out.println("maxHeight: " + maxHeight);
				maxHeight = Math.max(maxHeight, depth(i));
			}
			return maxHeight;
		}
	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new tree_height().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}

	public void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
}
