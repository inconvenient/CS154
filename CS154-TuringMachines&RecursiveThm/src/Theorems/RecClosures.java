package Theorems;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class RecClosures {
	
	// returns memC for C = A U B
	public static Predicate<Integer> union(Predicate<Integer> memA,
			Predicate<Integer> memB) {
		return (n) -> memA.test(n) || memB.test(n);
	}

	public static Predicate<Integer> intersect(Predicate<Integer> memA,
			Predicate<Integer> memB) {
		return (n) -> memA.test(n) && memB.test(n);
	}

	public static Predicate<Integer> relComp(Predicate<Integer> memA,
			Predicate<Integer> memB) {
		return (n) -> memA.test(n) && !memB.test(n);
	}

	public static BiPredicate<Integer, Integer> cross(Predicate<Integer> memA,
			Predicate<Integer> memB) {
		return (n, m) -> memA.test(n) && memB.test(m);
	}

	// TESTERS
	
	public static boolean membership(Integer n) {
		ArrayList members = new ArrayList<Integer>();
		members.add(1);
		members.add(2);
		members.add(3);
		
		return members.contains(n);
	}
	
	public static boolean membership2(Integer n) {
		ArrayList members = new ArrayList<Integer>();
		members.add(6);
		members.add(4);
		members.add(1);
		
		return members.contains(n);
	}
	
	public static void main (String args[]) {
		Predicate<Integer> unionMem = union(RecClosures::membership, RecClosures::membership2);
		System.out.println("Set 1: {1, 2, 3} // Set 2: {6, 4, 1}");
		System.out.println("UNION: 2 --> " + unionMem.test(2));
		System.out.println("UNION: 9 --> " + unionMem.test(9));
		System.out.println("-----------------");
		
		Predicate<Integer> intersectMem = intersect(RecClosures::membership, RecClosures::membership2);
		System.out.println("Set 1: {1, 2, 3} // Set 2: {6, 4, 1}");
		System.out.println("INTERSECT: 1 --> " + intersectMem.test(1));
		System.out.println("INTERSECT: 2 --> " + intersectMem.test(2));
		System.out.println("-----------------");
		
		Predicate<Integer> relCompMem = relComp(RecClosures::membership, RecClosures::membership2);
		System.out.println("Set 1: {1, 2, 3} // Set 2: {6, 4, 1}");
		System.out.println("RELCOMP: 2 --> " + relCompMem.test(2));
		System.out.println("RELCOMP: 1 --> " + relCompMem.test(1));
		System.out.println("-----------------");
		
		BiPredicate<Integer, Integer> crossMem = cross(RecClosures::membership, RecClosures::membership2);
		System.out.println("Set 1: {1, 2, 3} // Set 2: {6, 4, 1}");
		System.out.println("CartPr: 1, 4 --> " + crossMem.test(1, 4));
		System.out.println("CartPr: 5, 1 --> " + crossMem.test(5, 1));
		System.out.println("-----------------");
	}

}
