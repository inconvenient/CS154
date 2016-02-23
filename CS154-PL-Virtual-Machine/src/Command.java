import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Command {

	private String label;
	private String opCode;
	private String arg1;
	private String arg2;
	private int target;
	private int pc;
	private int count;
	private Pattern cmmdPattern;

	public Command(String cmmd, int progCounter) {
		parse(cmmd);
		pc = progCounter;
	}

	// Helper method to separate label, opCode and args
	// Adds each part to the chunks AList
	public void parse(String cmmd) {

		cmmdPattern = Pattern
				.compile("([A-Z]+:\\s{1}){0,1}(load|goto|inc|loop|end){0,1}(\\s[A-Za-z0-9]+){0,1}(\\s[A-Za-z0-9]+){0,1}");
		Matcher cmmdMatcher = cmmdPattern.matcher(cmmd);
		boolean check = cmmdMatcher.matches();

		// Check for label
		if (cmmdMatcher.group(1) != null) {
			label = cmmdMatcher.group(1).trim().replaceAll(":", "");
			
		} else {
			label = null;
		}

		opCode = cmmdMatcher.group(2).trim();

		// Check for arg1
		if (cmmdMatcher.group(3) != null) {
			arg1 = cmmdMatcher.group(3).trim();
		}

		// Check for arg2
		if (cmmdMatcher.group(4) != null) {
			arg2 = cmmdMatcher.group(4).trim();
		}
	}

	public String getArg1() {
		return arg1;
	}

	public String getArg2() {
		return arg2;
	}

	public int getTarget() {
		return target;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int c) {
		this.count = c;
	}

	public String getLabel() {
		return label;
	}

	public String getOpCode() {
		return opCode;
	}

	public int getPC() {
		return pc;
	}

	public void setPC(int progC) {
		this.pc = progC;
	}

	public void setTarget(int t) {
		this.target = t;
	}

	@Override
	public String toString() {
		return "Command [label=" + label + ", opCode=" + opCode + ", arg1="
				+ arg1 + ", arg2=" + arg2 + ", target=" + target + ", pc=" + pc
				+ ", count=" + count + "]";
	}

}
