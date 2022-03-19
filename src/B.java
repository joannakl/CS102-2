
public class B extends A{

	public B(int n) {
		super(n);
	}
	public void update(int n) {
		num = num + n;
	}
	public static void main(String[] args) {
		A a1 = new A(5);
		A a2= new B(7);
		B b1 = (B) a2;
		a1.update(10);
		a2.update(10);
		b1.update(10);
		System.out.println(a1.num);
		System.out.println(a2.num);
		System.out.println(b1.num);
	}

}
