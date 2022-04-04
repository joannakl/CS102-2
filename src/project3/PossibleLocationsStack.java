package project3;

import java.util.LinkedList;

class PossibleLocationsStack implements PossibleLocations {
	
	Node top;
	private class Node {
		Location data; 
		Node link;
	}

	public PossibleLocationsStack() {
		this.top = null;
	}

	public void add(Location s) {

		Node temp = new Node();

		temp.data = s;

		temp.link = top;


		top = temp;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public Location peek() {

		if (!isEmpty()) {
			return top.data;
		}
		else {
			System.out.println("Stack is empty");
			System.exit(0);
			return null;
		}
	}

	public Location remove() { 
		Node temp = new Node();
	
		if (top == null) {
			System.out.print("\nStack Underflow");
			return null;
		}

		temp.data = top.data;
		temp.link = top.link;
		top = (top).link;
		return temp.data;
	}

	public void display() {
		
		if (top == null) {
			System.err.print("Top is null");
			System.exit(0);
		}
		else {
			Node temp = top;
			while (temp != null) {

				System.out.printf("%d->", temp.data);

				temp = temp.link;
			}
		}
	}




}
	// main class
	

