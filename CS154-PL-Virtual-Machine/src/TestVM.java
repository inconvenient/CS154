public class TestVM {

	public static VM vm = new VM();

	public static void main(String[] args) {
		// test1();
		// test2();
		// test3();
		// test4();
		// test5();
		// test6();
		// hyperTest1();
		// hyperTest2();
		// hyperTest3();
		hyperTest4();
	}

	// Dr. Pearce's Test : Expected Value = (x = 10, y = 16)
	public static void test1() {
		try {
			vm.add("load x 10");
			vm.add("load y 5");
			vm.add("loop x");
			vm.add("inc y");
			vm.add("end");
			vm.add("goto AAA");
			vm.add("inc y");
			vm.add("AAA: inc y");
			vm.run();
			System.out.println(vm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// n + m : Expected Value = 7
	public static void test2() {
		try {
			// 3 + 4
			vm.add("load n 3");
			vm.add("load m 4");
			vm.add("loop m");
			vm.add("inc n");
			vm.add("end");
			vm.run();
			System.out.println(vm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// x * y : Expected Value of z = 9
	public static void test3() {
		try {
			// 3 * 3
			vm.add("load x 3");
			vm.add("load y 3");
			vm.add("load w 0");
			vm.add("load z 0");
			vm.add("loop x");
			vm.add("loop y");
			vm.add("inc w");
			vm.add("end");
			vm.add("end");
			vm.add("load z w");
			vm.run();
			System.out.println(vm);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// m - 1 : Expected Value of y = 3
	public static void test4() {
		try {
			// 4 - 1
			vm.add("load x 4");
			vm.add("load y 0");
			vm.add("load w 0");
			vm.add("loop x");
			vm.add("load y w");
			vm.add("inc w");
			vm.add("end");
			vm.run();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// a - b = x : Expected Value of x = 3;
	public static void test5() {
		try {
			// 9 - 6
			vm.add("load a 9");
			vm.add("load b 6");
			vm.add("load c 0");
			vm.add("load d 0");
			vm.add("load x a");

			vm.add("loop b");
			vm.add("loop x");
			vm.add("load c d");
			vm.add("inc d");
			vm.add("end");
			vm.add("load x c");
			vm.add("load c 0");
			vm.add("load d 0");
			vm.add("end");

			vm.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// max(m, n) || Variable z is the final answer
	public static void test6() {
		try {
			vm.add("load m 8");
			vm.add("load n 5");
			vm.add("load c 0");
			vm.add("load d 0");
			vm.add("load x m");

			vm.add("loop n");
			vm.add("loop x");
			vm.add("load c d");
			vm.add("inc d");
			vm.add("end");
			vm.add("load x c");
			vm.add("load c 0");
			vm.add("load d 0");
			vm.add("end");

			// if m is larger than n, load value of m into z
			// else n is larger and z is still n
			vm.add("load z n");
			vm.add("loop x"); // x = m - n
			vm.add("load z m");
			vm.add("end");

			vm.run();

			System.out.println("max(m, n)");
			System.out.println("TO GRADER: Final Answer is value of z");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// double 2x
	public static void hyperTest1() {
		try {
			vm.add("load x 5");
			vm.add("loop x");
			vm.add("inc x");
			vm.add("end");

			vm.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// exp(x): 2^x = a | Expected Value of a is 8
	public static void hyperTest2() {
		try {
			vm.add("load a 1");
			vm.add("load x 3");
			
			vm.add("loop x");
			vm.add("loop a");
			vm.add("inc a");
			vm.add("end");
			vm.add("end");

			vm.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// hyper1Exp(x) | Expected Value of a is 4
	public static void hyperTest3() {
		try {
			vm.add("load a 1");
			vm.add("load x 2");
			
			vm.add("loop a");
			vm.add("loop x");
			vm.add("loop a");
			vm.add("inc a");
			vm.add("end");
			vm.add("end");
			vm.add("end");

			vm.run();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// hyper2Exp
	public static void hyperTest4() {
		try {
			vm.add("load a 1");
			vm.add("load x 2");
			
			
			vm.add("loop a");
			vm.add("loop x");
			vm.add("loop a");
			vm.add("inc a");
			vm.add("end");
			vm.add("end");
			vm.add("end");
			vm.add("end");
			
			vm.run();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// hyper3Exp
	public static void hyperTest5() {
		try {
			vm.add("load a 1");
			vm.add("load x 2");
			
			vm.add("loop a");
			vm.add("loop x");
			vm.add("loop a");
			vm.add("inc a");
			vm.add("end");
			vm.add("end");
			vm.add("end");

			vm.run();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
