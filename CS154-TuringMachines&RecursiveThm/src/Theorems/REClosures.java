package Theorems;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class REClosures {

	// assumes f & g are enumerators for A and B, resp.
	public static UnaryOperator<Integer> union(UnaryOperator<Integer> f,
			UnaryOperator<Integer> g) {
		return x -> (x % 2 == 0) ? f.apply(x) : g.apply(x);
	}

	// assumes f & g are recognizers for A and B, resp.
	public static UnaryOperator<Integer> intersection(UnaryOperator<Integer> f,
			UnaryOperator<Integer> g) {
		return x -> f.apply(x) + g.apply(x); // +, *, /, whatever
	}

	// assumes f & g are recognizers for A and B, resp.
	public static BinaryOperator<Integer> product(UnaryOperator<Integer> f,
			UnaryOperator<Integer> g) {
		return (x, y) -> f.apply(x) + g.apply(y);
	}

}