package fr.insa_rennes.sdd.priority_queue;

import fr.insa_rennes.sdd.util.ArraySupport;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HeapPQ<T> implements PriorityQueue<T> {
	private static final int DEFAULT_INITIAL_CAPACITY = 8;
	private Comparator<? super T> comparator;
	private int size;
	T[] heap;

	public HeapPQ() {
		this(DEFAULT_INITIAL_CAPACITY, null);
	}	

	public HeapPQ(int initialCapacity) {
		this(initialCapacity, null);
	}

	public HeapPQ(Comparator<? super T> comparator) {
		this(DEFAULT_INITIAL_CAPACITY, comparator);
	}

	@SuppressWarnings("unchecked")
	public HeapPQ(int initialCapacity, Comparator<? super T> comparator) {
		if (initialCapacity < 1) {
			throw new IllegalArgumentException();
		}
		heap = (T[])new Object[initialCapacity];
		this.comparator =
				comparator == null ? (t1, t2) -> ((Comparable<? super T>)t1).compareTo(t2) : comparator;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void add(T e) {
		if(e == null){
			throw new NullPointerException();
		}
		if(this.size >= heap.length){
			grow();
		}
		this.heap[size] = e;
		tamiserVersLeHaut(size);
		size++;
	}

	private void tamiserVersLeHaut(int index){
		T e = this.heap[index];
		int index_pere = index % 2 != 0 ? index / 2 : (index / 2)-1;
		while(index > 0 && this.comparator.compare(e,this.heap[index_pere]) > 0){
			this.heap[index] = this.heap[index_pere];
			this.heap[index_pere] = e;
			index = index % 2 != 0 ? index / 2 : (index / 2)-1;
			index_pere = index % 2 != 0 ? index / 2 : (index / 2)-1;
		}
		this.heap[index] = e;
	}

	private void grow() {
		int oldLength = heap.length;
		heap = Arrays.copyOf(heap, ArraySupport.newLength(oldLength, oldLength + 1, oldLength << 1));
	}

	@Override
	public T peek() {
		throw new UnsupportedOperationException();
	}

	@Override
	public T poll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		String res = "[ ";
		for(T e : this.heap){
			if(e == null){
				res+="null ";
				continue;
			}
			else {
				res += e.toString() + " ";
			}

		}
		return res + "]";
	}
}
