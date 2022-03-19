
public class Foo {
	int x;
	int y;
	
	public Foo(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(this == obj) return true;
		if(!(obj instanceof Foo)) return false;
		Foo other = (Foo) obj;
		if(this.x == other.x && this.y == other.y)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Foo f1 = new Foo(5,10);
		Foo f2 = new Foo(5,10);
		
		System.out.println(f1.equals( f2 ));
	}
}
