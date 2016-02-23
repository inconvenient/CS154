public class Concat implements RegEx {

	public RegEx reg1;
	public RegEx reg2;

	public Concat(RegEx r1, RegEx r2) {
		reg1 = r1;
		reg2 = r2;
	}

	@Override
	public boolean matches(String s) {
		for (int i = 0; i < s.length(); i++) {
			String prefix = s.substring(0, i);
			String suffix = s.substring(i);
			if (reg1.matches(prefix) && reg2.matches(suffix))
				return true;
		}
		return false;
	}

}
