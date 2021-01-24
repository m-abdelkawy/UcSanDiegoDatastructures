package week2practice;

import java.util.Iterator;

public class BinaryCounterWithReset {
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	int[] A;
	int maxA = -1;

	public BinaryCounterWithReset(int size) {
		A = new int[size];
	}

	public void increment() { // O(n) for sequence of n operations
		int i = 0;
		while (i < A.length && A[i] == 1)
			A[i++] = 0;

		if (A[i] == 0) {
			A[i] = 1;
			if (i > maxA) {
				maxA = i;
			} else {
				maxA = -1;
			}   
		}
	}

	public void reset() {
		for (int i = 0; i < maxA; i++) {
			A[i] = 0;
		}
	}

	public void displayHeader() {
		String str = "x\t";
		for (int i = 0; i < A.length; i++) {
			str += "A[" + (A.length - 1 - i) + "]\t";
		}
		System.out.println(str);
	}

	public void displayCount() {
		System.out.print(count() + "\t");
		for (int i = 0; i < A.length; i++) {
			if (A[A.length - 1 - i] == 1)
				System.out.print(ANSI_RED + A[A.length - 1 - i] + "\t");
			else
				System.out.print(ANSI_BLACK + A[A.length - 1 - i] + "\t");
		}
		System.out.println();
	}

	public int count() {
		int x = 0;
		for (int i = 0; i < A.length; i++) {
			x += A[i] * Math.pow(2, i);
		}
		return x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryCounter counter = new BinaryCounter(8);

		counter.displayHeader();
		counter.displayCount();
		for (int i = 1; i < 17; i++) {
			counter.increment();
			counter.displayCount();
		}
	}
}
