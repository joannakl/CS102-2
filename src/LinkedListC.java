
/*
A linked list class. Elements are of type int. 
*/

public class LinkedListC {

    //define internal Node class 
    private class Node { 
        public int data; 
        public Node next; 

        public Node (int data) {
            this.data = data;
            this.next = null; 
        }
    }
    
    private Node head;
    private Node tail; 
    private int size; 


    /*
    * Creates an empty list object.  
    */
    public LinkedListC() {
        head = null;
        tail = null;
    }

    /* 
    * Adds an element 'num' at the end of this list. 
    * @param num the element to be added to this list 
    */
    public void add (int num) {
         //create a new node and start the counter 
         Node n = new Node(num);
         
         if (size == 0) {     //add to an empty list   
             head = n;
             tail = n;
         } 
         else {              //add to the end of the list
             tail.next = n;
             tail = n; 
         }
         size++; 
    }

 
    /*
    * Produces string representation of this list. 
    * The string contains all elemetns stored in the list, one per line.
    * @return returns the string representation of this list 
    */
    public String toString () {
        if (head == null ) return ""; 
        String toReturn = ""; 
        Node current = head; 
        while (current != null ) {
            toReturn += current.data + " "; 
            current = current.next;
        }
        return toReturn; 
    }



    /* 
     * Counts the number of occurances of a give value. 
     * @param val the value to count  
     * @return the number of occurances of 'val' or zero if the list is empty
     */ 
    public int count ( int val ) {
        int count = 0;
        Node curr = head;
        if(this.size == 0) {
        	return 0;
        }
        while (curr != null) {
            if (curr.data == val) {
                count++;
            }
            curr = curr.next;
        }
        return count;

     }


}
