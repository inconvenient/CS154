public class ExpParsers {

	public static Parser number = Combinator.regEx("[0-9]+");
	public static Parser operator = Combinator.regEx("\\+|\\*");
	public static Parser exp = new Parser();
	static {
		exp.setParser(Combinator.alt(
				Combinator.seq(number, Combinator.seq(operator, exp)), number));
	}
	
	public static void main(String[] args) {
		testExpParsers();
	}
	
	

	public static void test(Parser p, String s) {
		System.out.println("s = " + s);
		Result tree = p.apply(new Result(s));
		System.out.println("tree = " + tree);
		System.out.println("pending = " + tree.pending());
	}

	public static void testExpParsers() {
		String s = "42";
		test(ExpParsers.number, s);
		System.out.println("------------");
		s = "29z";
		test(ExpParsers.number, s);
		System.out.println("------------");
		s = "*";
		test(ExpParsers.operator, s);
		System.out.println("------------");
		s = "-";
		test(ExpParsers.operator, s);
		System.out.println("------------");
		s = "42 + 91 * 13 + 2";
		test(ExpParsers.exp, s);
		System.out.println("------------");
		s = "123";
		test(ExpParsers.exp, s);
		System.out.println("------------");
		s = "15 * 6 - 10";
		test(ExpParsers.exp, s);
	}
}