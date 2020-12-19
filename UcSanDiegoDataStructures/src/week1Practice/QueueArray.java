package week1Practice;

public class QueueArray<T> {
	T[] queue;
	int head, tail, capacity;

	public QueueArray() {
		queue = (T[]) new Object[1];
	}

	public QueueArray(int _capacity) {
		capacity = _capacity;
		queue = (T[]) new Object[capacity];
	}

	public boolean isEmpty() {
		return head == tail;
	}

	public boolean isFull() {
		return tail == capacity;
	}

	public void enqueue(T item) {
		if (isFull()) {
			System.out.println("Queue is full!");
			return;
		}
		queue[tail++] = item;
	}

	public T dequeue() {// FIFO
		if (isEmpty()) {
			System.out.println("queue is empty!");
			return null;
		}
		T res = queue[head];
		for (int i = 0; i < tail - 1; i++) {
			queue[i] = queue[i + 1];
		}
		queue[--tail] = null;
		return res;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
