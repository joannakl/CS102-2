package project1;

public class Main {
	void swap ( int d1, int d2 ) {
	    int tmp;
	    tmp = d1;
	    d1 = d2;
	    d2 = tmp;
	}
	public void main(String[] args) {
		int x = 3;
		int y = 7;
		swap(x,y);
		System.out.println(x + ", " + y ); 
	}
	
}
