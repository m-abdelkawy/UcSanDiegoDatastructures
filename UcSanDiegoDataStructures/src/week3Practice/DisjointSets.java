package week3Practice;

import java.util.Iterator;

public class DisjointSets {
	int[] components, representatives;
	int n;

	public DisjointSets(int n) {
		this.n = n;
		components = new int[n];
		representatives = new int[n];
		makeSet();
	}

	private void makeSet() {// O(n)
		for (int i = 0; i < n; i++) {
			representatives[i] = components[i];
		}
	}

	private void makeSet(int i) {// O(1)
		representatives[i] = i;
	}

	private int find(int i) {// O(1)
		return representatives[i];
	}

	private void union(int i, int j) {//O(n)
		int rep_i = find(i);
		int rep_j = find(j);

		if (rep_i == rep_j)
			return;

		int min = Math.min(rep_i, rep_j);

		for (int k = 0; k < n; k++) {
			if (representatives[k] == rep_i || representatives[k] == j)
				representatives[k] = min;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
