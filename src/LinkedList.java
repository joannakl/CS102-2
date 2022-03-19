import java.util.Iterator;

import LinkedListC.Node;

public class LinkedList<E> implements Iterable<E>{

	@Override
	 private class Node { 
        public int data; 
        public Node next; 

        public Node (int data) {
            this.data = data;
            this.next = null; 
        }
    }
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	Node<E> head;
	
	public void foo (E data) {
		Node<E> n = new Node<>(data);
	}

}
