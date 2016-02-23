
public class RegExpLab {
	
	public static void testBlocks() {
		String leading0 = "(0+1+)+0*"; // Any # of (start) 0 and 1 and ends with 0
		String leading1 = "(1+0+)+1*"; // Any # of (start) 1 or 0 and ends with 1
		String regExp = leading0 + "|" + leading1;
		
		System.out.println("".matches(regExp));
		System.out.println("0000".matches(regExp));
		System.out.println("11101010".matches(regExp));
		System.out.println("20201010".matches(regExp));
		System.out.println("000111000111".matches(regExp));
		System.out.println("11011".matches(regExp));
		System.out.println("Ayyy".matches(regExp));
	}
	
	public static void testMoney() {
		String moneyExp = "^\\$(0|[1-9][0-9])\\.([0-9][0-9])";
		
		System.out.println("$12.00".matches(moneyExp));
		System.out.println("$10.00".matches(moneyExp));
		System.out.println("$0.10".matches(moneyExp));
		System.out.println("$00.30".matches(moneyExp));
		System.out.println("$.10".matches(moneyExp));
		System.out.println("321.2".matches(moneyExp));
		System.out.println("21.221".matches(moneyExp));
	}
	
	public static void testPoly() {
		
		String coeff = "([1-9][0-9]*(.[0-9]+)?)";
		String var = "([a-z])";
		String exp = "\\^([2-9][0-9]*|(1([0-9]+)+)$)";
		String mono = coeff + var + exp;
		String poly = "???";
		
		System.out.println("3x^15".matches(mono));
		System.out.println("2x^2+2x+4".matches(poly));
		
	}
	
	public static void main(String args[]) {
		testPoly();
	}

}
