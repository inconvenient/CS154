public class Option implements RegEx {

	public RegEx reg;

	public Option(RegEx r) {
		reg = r;
	}

	@Override
	public boolean matches(String s) {
		return s.isEmpty() || reg.matches(s);
	}

}
