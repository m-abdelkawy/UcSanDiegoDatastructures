//package week1Assignment;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;


class QueueTwoStacks {
	public Stack<Integer> inbox = new Stack<Integer>();
	public Stack<Integer> outbox = new Stack<Integer>();

	public Stack<Integer> trackInbox = new Stack<Integer>();;
	// public Stack<Integer> trackOutBox = new Stack<Integer>();

	private void fromTo(Stack<Integer> from, Stack<Integer> to) {
		Iterator<Integer> itr = from.iterator();
		while (itr.hasNext()) {
			to.push(from.pop());
		}
	}
	
	private void InboxToOutbox() {
		Iterator<Integer> itr = inbox.iterator();
		while (itr.hasNext()) {
			outbox.push(inbox.pop());
		}
	}

	/*
	 * void inboxToOutbox() { Iterator<Integer> itr = inbox.iterator(); while
	 * (itr.hasNext()) { outbox.push(inbox.pop()); } }
	 * 
	 * void outBoxToInbox() { Iterator<Integer> itr = outbox.iterator(); while
	 * (itr.hasNext()) { inbox.push(outbox.pop()); } }
	 */

	public void enqueue(int item) {
		inbox.push(item);

		/*if (!trackInbox.isEmpty())
			trackInbox.push(Math.max(item, trackInbox.peek()));
		else
			trackInbox.push(item);*/
	}

	public int dequeue() {
		if (outbox.isEmpty()) {

			//fromTo(inbox, outbox);
			InboxToOutbox();
		}

		// fromTo(trackInbox, trackOutBox);

		int res = outbox.pop();

		// trackOutBox.pop();

		// fromTo(outbox, inbox);

		// fromTo(trackOutBox, trackInbox);

		//System.out.print("Dequeue Called ");
		//display();

		return res;
	}

	public int peek() {
		if (outbox.isEmpty()) {

			fromTo(inbox, outbox);
		}

		int res = outbox.peek();

		return res;
	}

	/*
	 * public int max() { trackInbox = new Stack<Integer>(); Iterator<Integer> itr =
	 * inbox.iterator(); while (itr.hasNext()) { if(!trackInbox.isEmpty()) {
	 * trackInbox.push(Math.max(trackInbox.peek(), itr.next())); }else {
	 * trackInbox.push(itr.next()); } } return trackInbox.peek(); }
	 */

	public int max() {
		trackInbox = new Stack<Integer>();
		
		Iterator<Integer> itrInbox = inbox.iterator();
		while (itrInbox.hasNext()) {
			if (!trackInbox.isEmpty()) {
				trackInbox.push(Math.max(trackInbox.peek(), itrInbox.next()));
			} else {
				trackInbox.push(itrInbox.next());
			}
		}
		
		Iterator<Integer> itrOutbox = outbox.iterator();
		while (itrOutbox.hasNext()) {
			if (!trackInbox.isEmpty()) {
				trackInbox.push(Math.max(trackInbox.peek(), itrOutbox.next()));
			} else {
				trackInbox.push(itrOutbox.next());
			}
		}
		return trackInbox.peek();

	}

	public boolean isEmpty() {
		return inbox.size() == 0 && outbox.size() == 0;
	}

	public int size() {
		return inbox.size() + outbox.size();
	}

	public void display() {
		System.out.print("Queue: ");

		Iterator<Integer> itrInbox = inbox.iterator();
		while (itrInbox.hasNext()) {
			System.out.print(itrInbox.next() + "\t");
		}

		ArrayList<Integer> lstOutboxList = new ArrayList<Integer>();
		Iterator<Integer> itrOutbox = outbox.iterator();
		while (itrOutbox.hasNext()) {
			lstOutboxList.add(itrOutbox.next());
		}

		for (int i = lstOutboxList.size() - 1; i >= 0; i--) {
			System.out.print(lstOutboxList.get(i) + "\t");
		}

		System.out.println();
	}
}

class FastScanner {
	StringTokenizer tok = new StringTokenizer("");
	BufferedReader in;

	FastScanner() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() throws IOException {
		while (!tok.hasMoreElements())
			tok = new StringTokenizer(in.readLine());

		return tok.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
}

public class max_sliding_window {
	QueueTwoStacks queue = new QueueTwoStacks();

	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> trackStack = new Stack<Integer>();

	Stack<Integer> inbox = new Stack<Integer>();
	Stack<Integer> outbox = new Stack<Integer>();

	/*
	 * int max(int[] A) { for (int i = 0; i < A.length; i++) { stack.add(A[i]); if
	 * (!stack.isEmpty() && A[i] < trackStack.peek()) {
	 * trackStack.add(trackStack.peek()); } else { trackStack.add(A[i]); } } return
	 * trackStack.peek(); }
	 */

	void maxSlidingWindow(int[] A, int m) {
		// int max = 0;
		for (int i = 0; i < m; i++) {
			queue.enqueue(A[i]);
		}
		// max = queue.max();
		for (int i = m; i < A.length; i++) {
			//System.out.println("Iteration m: " + m);
			//queue.display();
			//System.out.println("Max: " + queue.max() + "\t");
			System.out.print(queue.max() + "\t");
			queue.dequeue();
			queue.enqueue(A[i]);
			// max = Math.max(max, queue.max());
			//System.out.println("========================");
		}
		System.out.print(queue.max());
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FastScanner scanner = new FastScanner();
		int n = scanner.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		int m = scanner.nextInt();
		new max_sliding_window().maxSlidingWindow(A, m);
	}

}
