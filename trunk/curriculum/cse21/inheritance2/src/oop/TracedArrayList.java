package oop;

import java.util.ArrayList;

class TracedArrayList<E> extends ArrayList<E> {
	
	int myLongestLengthSoFar = 0;
	
	public int maxLengthSoFar ( ) {
		return myLongestLengthSoFar;
	}
	
	
	public boolean add (E e) {
		super.add (e);
		if (size ( ) > myLongestLengthSoFar) {
			myLongestLengthSoFar = size ( );
		}
		return true;
	}	
	
	
	public static void main(String[] args) {
		TracedArrayList<Integer> t = new TracedArrayList<Integer>( );
		Integer v = new Integer (1);
		t.add (v);
		t.add (v);
		System.out.println (t.maxLengthSoFar ( ));
		t.remove (0);
		System.out.println (t.maxLengthSoFar ( ));
		t.remove (0);
		System.out.println (t.maxLengthSoFar ( ));
		t.add (v);
		System.out.println (t.maxLengthSoFar ( ));
		t.add (v);
		System.out.println (t.maxLengthSoFar ( ));
		t.add (v);
		System.out.println (t.maxLengthSoFar ( ));
	}
}
