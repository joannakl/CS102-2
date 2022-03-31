package project3;

import java.util.LinkedList;

class PossibleLocationsStack implements PossibleLocations {
	
	Node top;

    // A linked list node
	private class Node {

		Location data; // integer data
		Node link; // reference variable Node type
		}
	// create global top reference variable global
	
	
	
	// Constructor
	PossibleLocationsStack() {
		this.top = null;
	}
	 
	// Utility function to add an element x in the stack
	public void add(Location s) { // insert at the beginning

		// create new node temp and allocate memory
		Node temp = new Node();

		// check if stack (heap) is full. Then inserting an
		//  element would lead to stack overflow
		if (temp == null) {
			System.out.print("\nHeap Overflow");
			return ;
		}

		// initialize data into temp data field
		temp.data = s;

		// put top reference into temp link
		temp.link = top;

		// update top reference
		top = temp;
	}

	// Utility function to check if the stack is empty or not
	public boolean isEmpty() {
		return top == null;
	}

	// Utility function to return top element in a stack
	public Location peek() {
		// check for empty stack
		if (!isEmpty()) {
			return top.data;
		}
		else {
			System.out.println("Stack is empty");
			System.exit(0);
			return null;
		}
	}

	// Utility function to pop top element from the stack
	public Location remove() { // remove at the beginning
		Node temp = new Node();
		// check for stack underflow
		if (top == null) {
			System.out.print("\nStack Underflow");
			return null;
		}

		// update the top pointer to point to the next node
		temp.data = top.data;
		temp.link = top.link;
		top = (top).link;
		return temp.data;
	}

	public void display() {
		// check for stack underflow
		if (top == null) {
			System.err.print("Top is null");
			System.exit(0);
		}
		else {
			Node temp = top;
			while (temp != null) {

				// print node data
				System.out.printf("%d->", temp.data);

				// assign temp link to temp
				temp = temp.link;
			}
		}
	}




}
	// main class
	

