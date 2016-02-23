public class FSMTest {

	public static void main(String[] args) {
		FSM m = new FSM();
		m.addTransition('0', 0, 1);
		m.addTransition('0', 1, 1);
		m.addTransition('1', 1, 2);
		m.addTransition('0', 2, 3);
		m.addTransition('1', 2, 2);
		m.addTransition('0', 3, 3);
		m.addFinalState(3);

		System.out.println("0011100: " + m.accept("0011100"));
		System.out.println("01100: " + m.accept("01100"));
		System.out.println("11100: " + m.accept("11100"));
		System.out.println("001110011: " + m.accept("001110011"));

		m.reset(); // clear all transitions and final states

		System.out.println("___NAT REGEX TEST___");

		m.addTransition('0', 0, 2);
		m.addTransition('1', 0, 1);
		m.addTransition('2', 0, 1);
		m.addTransition('3', 0, 1);
		m.addTransition('4', 0, 1);
		m.addTransition('5', 0, 1);
		m.addTransition('6', 0, 1);
		m.addTransition('7', 0, 1);
		m.addTransition('8', 0, 1);
		m.addTransition('9', 0, 1);
		m.addTransition('0', 1, 1);
		m.addTransition('1', 1, 1);
		m.addTransition('2', 1, 1);
		m.addTransition('3', 1, 1);
		m.addTransition('4', 1, 1);
		m.addTransition('5', 1, 1);
		m.addTransition('6', 1, 1);
		m.addTransition('7', 1, 1);
		m.addTransition('8', 1, 1);
		m.addTransition('9', 1, 1);
		m.addFinalState(2);	
		
		System.out.println("0: " + m.accept("0"));
		System.out.println("1: " + m.accept("1"));
		System.out.println("123412: " + m.accept("123412"));
		System.out.println("0142: " + m.accept("0142"));
		
		m.reset();
		
		System.out.println("___DATE REGEX TEST___");
		
		m.addTransition('0', 0, 1);
		m.addTransition('1', 0, 1);
		m.addTransition('2', 0, 1);
		m.addTransition('3', 0, 1);
		m.addTransition('4', 0, 1);
		m.addTransition('5', 0, 1);
		m.addTransition('6', 0, 1);
		m.addTransition('7', 0, 1);
		m.addTransition('8', 0, 1);
		m.addTransition('9', 0, 1);

		m.addTransition('0', 1, 2);
		m.addTransition('1', 1, 2);
		m.addTransition('2', 1, 2);
		m.addTransition('3', 1, 2);
		m.addTransition('4', 1, 2);
		m.addTransition('5', 1, 2);
		m.addTransition('6', 1, 2);
		m.addTransition('7', 1, 2);
		m.addTransition('8', 1, 2);
		m.addTransition('9', 1, 2);
		
		m.addTransition('/', 2, 3);
		
		m.addTransition('0', 3, 4);
		m.addTransition('1', 3, 4);
		m.addTransition('2', 3, 4);
		m.addTransition('3', 3, 4);
		m.addTransition('4', 3, 4);
		m.addTransition('5', 3, 4);
		m.addTransition('6', 3, 4);
		m.addTransition('7', 3, 4);
		m.addTransition('8', 3, 4);
		m.addTransition('9', 3, 4);

		m.addTransition('0', 4, 5);
		m.addTransition('1', 4, 5);
		m.addTransition('2', 4, 5);
		m.addTransition('3', 4, 5);
		m.addTransition('4', 4, 5);
		m.addTransition('5', 4, 5);
		m.addTransition('6', 4, 5);
		m.addTransition('7', 4, 5);
		m.addTransition('8', 4, 5);
		m.addTransition('9', 4, 5);
		
		m.addTransition('/', 5, 6);
		
		m.addTransition('0', 6, 7);
		m.addTransition('1', 6, 7);
		m.addTransition('2', 6, 7);
		m.addTransition('3', 6, 7);
		m.addTransition('4', 6, 7);
		m.addTransition('5', 6, 7);
		m.addTransition('6', 6, 7);
		m.addTransition('7', 6, 7);
		m.addTransition('8', 6, 7);
		m.addTransition('9', 6, 7);

		m.addTransition('0', 7, 8);
		m.addTransition('1', 7, 8);
		m.addTransition('2', 7, 8);
		m.addTransition('3', 7, 8);
		m.addTransition('4', 7, 8);
		m.addTransition('5', 7, 8);
		m.addTransition('6', 7, 8);
		m.addTransition('7', 7, 8);
		m.addTransition('8', 7, 8);
		m.addTransition('9', 7, 8);
		m.addFinalState(8);
		
		System.out.println("3/4/14: " + m.accept("3/4/14"));
		System.out.println("02/21/13: " + m.accept("02/21/13"));
		System.out.println("12/14/15: " + m.accept("12/14/15"));
		System.out.println("4/2/4: " + m.accept("4/2/4"));
		
		m.reset();
		
		System.out.println("___NAME REGEX TEST___");
		
		m.addTransition('a', 0, 1);
		m.addTransition('b', 0, 1);
		m.addTransition('c', 0, 1);
		m.addTransition('a', 1, 1);
		m.addTransition('b', 1, 1);
		m.addTransition('c', 1, 1);
		m.addTransition('0', 1, 1);
		m.addTransition('1', 1, 1);
		m.addTransition('2', 1, 1);
		m.addTransition('3', 1, 1);
		m.addTransition('4', 1, 1);
		m.addTransition('5', 1, 1);
		m.addTransition('6', 1, 1);
		m.addTransition('7', 1, 1);
		m.addTransition('8', 1, 1);
		m.addTransition('9', 1, 1);
		m.addFinalState(2);
		
		System.out.println("bb: " + m.accept("bb"));
		System.out.println("a9: " + m.accept("a9"));
		System.out.println("c999999: " + m.accept("c999999"));
		System.out.println("90a: " + m.accept("90a"));
		
		m.reset();
	}

}
