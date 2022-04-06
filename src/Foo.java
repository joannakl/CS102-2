
public class foo {
	static void foo ( int length ) {
		foo (length, "");
		}
	static void foo ( int length, String seq ) {
		if (seq.length() == length ) {
		System.out.printf("%s \n", seq );
		return;
		}
		String seq0 = seq + "O";
		foo( length, seq0);
		if (seq.length() != 0 ) {
			String seq1 = seq + "1";
			foo( length, seq1);
		}
	}
	public static void main(String[] args) {
		foo(4);
	}

}
