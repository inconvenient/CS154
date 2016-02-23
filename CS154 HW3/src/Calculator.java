
/* public class Calculator extends Console {

	private String regEx = "((\\+|-)?[1-9][0-9]*(\\.[0-9]+)?)\\s*(\\+|\\*)\\s*((\\+|-)?[1-9][0-9]*(\\.[0-9]+)?)";
	private Pattern exp = Pattern.compile(regEx); // only do this once

	protected String execute(String cmmd) throws Exception {
		String result = "";
		Matcher m = exp.matcher(cmmd);
		if (m.matches()) {
			Double arg1 = new Double(m.group(1));
			Double arg2 = new Double(m.group(5));
			String op = m.group(4);
			if (op.equals("+"))
				result = "" + (arg1 + arg2);
			else if (op.equals("*"))
				result = "" + (arg1 * arg2);
			else
				throw new Exception("unrecognized opertor: " + op);
		} else
			throw new Exception("syntax error");
		return result;
	}

	public static void main(String[] args) {
		Calculator ui = new Calculator();
		ui.controlLoop();
	}
} */