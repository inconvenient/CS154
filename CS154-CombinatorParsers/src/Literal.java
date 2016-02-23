public class Literal extends Result {

	protected String token;

	public Literal() {

	}

	@Override
	public String toString() {
		if (this.fail == true) {
			return "fail";
		} else 
		return "<" + token + ">";
	}
}
