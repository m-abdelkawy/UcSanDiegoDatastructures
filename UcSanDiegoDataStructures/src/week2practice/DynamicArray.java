package week2practice;

import java.util.Iterator;

public class DynamicArray<T> {

	private int size;
	private int capacity;
	T[] arr;

	DynamicArray() {
		arr = (T[]) new Object[capacity];
	}

	T get(int i) {
		if (i < 0 || i >= size)
			throw new ArrayIndexOutOfBoundsException("Error: Index out of range");
		return arr[i];
	}

	void set(int i, T val) {
		if (i < 0 || i >= size)
			throw new ArrayIndexOutOfBoundsException("Error: Index out of range");
		arr[i] = val;
	}

	T pudhBack(T val) {
		if(size == capacity) {
			resizeArray(2 * capacity);
		}
		arr[size] = val;
		return arr[size++];//O(1)
	}

	void remove(int i) {
		for (int j = i + 1; j < size; j++) {
			arr[i] = arr[i + 1];
		}
		size--;
	}

	int size() {
		return size;
	}

	void resizeArray(int capacity) {
		T[] temp = (T[]) new Object[capacity];
		if(arr.length > capacity) {
			for (int i = 0; i < capacity; i++) {
				temp[i]= arr[i]; 
			}
		}
		else if(arr.length < capacity) {
			for (int i = 0; i < arr.length; i++) {
				temp[i]= arr[i]; 
			}
		}
		arr = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
