package Theorems;
import java.util.function.Function;

public class RecEnum {

	public static Function<Integer, Integer> unionEnum(Function<Integer, Integer> memA, Function<Integer, Integer> memB) {
		return (n) -> (memA.apply(n) != null) ? memA.apply(n) : memB.apply(n); 
		
	}
	
	public static Function<Integer, Integer> intersectEnum(Function<Integer, Integer> memA, Function<Integer, Integer> memB) {
		return (n) -> memA.andThen(memB).apply(n);
		
	}
	
	public static Function<Integer, Pairs> crossEnum(Function<Integer, Integer> memA, Function<Integer, Integer> memB) {
		return null;
		
	}

	// Test Functions
	public static Integer multiplyByTwo(Integer n) {
		return n * 2;
	}

	public static Integer multiplyByFour(Integer n) {
		return n * 4;
	}
	
	public static void main(String[] args) {
		Function<Integer, Integer> unionEnumTest = unionEnum(RecEnum::multiplyByTwo, RecEnum::multiplyByFour);
		Function<Integer, Integer> intEnumTest = intersectEnum(RecEnum::multiplyByTwo, RecEnum::multiplyByFour);
		System.out.println("Union Enum Test: " + unionEnumTest.apply(2));
		System.out.println("Int Enum Test: " + intEnumTest.apply(4));
	}
}
