
public class DemoParsers {
	
	public static Parser number = Combinator.regEx("[1-9][0-9]*");
	public static Parser name = Combinator.regEx("[a-zA-Z][a-zA-Z0-9]*");
	public static Parser boole = 
	public static Parser term = new Parser();
	static {
		term.setParser(Combinator.alt(Combinator.alt(name, number), boole));
	}
	public static Parser operator;
	public static Parser product;

}
