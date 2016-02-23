public class Iteration implements RegEx {

	public RegEx reg1;

	public Iteration(RegEx regex) {
		reg1 = regex;
	}

	@Override
	public boolean matches(String s) {
		if (reg1.matches(s)) return true;
		for(int i = 0; i < s.length(); i++) {
			String prefix = s.substring(0, i);
			String suffix = s.substring(i);
			if (reg1.matches(prefix) && this.matches(suffix)) return true;
		}
		return false;
	}
}
