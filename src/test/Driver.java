package test;

/*
This class can be used to test the implementation of the LinkedListA class.
To compile it, execute 
  javac Driver.java 
To run it, execute 
  java Driver 

DO NOT SUBMIT THIS CLASS AS PART OF YOUR EXAM.
*/



public class Driver {

  public static void main (String[] args) {
      LinkedListC list = new LinkedListC();
      int i; 

      for (i = 0; i < 5; i++) {
          list.add( 1 ); 
          list.add( 2 ); 
      }
      System.out.println(list);

      for (i=5 ; i >= 0; i--) {
          list.add( 5 ); 
      }
      System.out.println(list);
      System.out.println(list.count(1));




  }


}