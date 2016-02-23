public class Choice implements RegEx {

	public RegEx reg1;
	public RegEx reg2;

	public Choice(RegEx r1, RegEx r2) {
		reg1 = r1;
		reg2 = r2;
	}

	@Override
	public boolean matches(String s) {
		return reg1.matches(s) || reg2.matches(s);
	}

}
