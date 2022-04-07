import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> tmp = new ArrayList<Integer>(10);
		tmp.add(1);
		tmp.add(2);
		System.out.println(tmp.get(0));
		tmp.remove(0);
		System.out.println(tmp.get(0));

	}

}
