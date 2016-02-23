import java.util.function.UnaryOperator;

public class Parser implements UnaryOperator<Result> {

	UnaryOperator<Result> parser;

	public void setParser(UnaryOperator<Result> p) {
		parser = p;
	}

	@Override
	public Result apply(Result r) {
		return parser.apply(r);
	}

	public UnaryOperator<Result> getParser() {
		return parser;
	}
}
