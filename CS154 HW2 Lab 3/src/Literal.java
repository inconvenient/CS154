public class Literal implements RegEx {

	private String token;

	public Literal(String string) {
		token = string; // token == 0 or 1
	}

	@Override
	public boolean matches(String s) {

		return token.equals(s);
	}
}
