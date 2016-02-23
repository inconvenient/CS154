public class Combinator {

	// returns p1 | p2
	public static Parser alt(Parser p1, Parser p2) {
		Parser parser = new Parser();
		parser.setParser(result -> {
			if (result.fail) {
				return result;
			}

			Choice answer = new Choice();
			answer.choice = p1.apply(result);
			if (answer.choice.fail) {
				answer.choice = p2.apply(result);
			}
			if (answer.choice.fail)
				return answer.choice;
			answer.unseen = answer.choice.unseen;
			return answer;
		});
		return parser;
	}

	// returns p1 ~ p2
	public static Parser seq(Parser p1, Parser p2) {
		Parser parser = new Parser();
		parser.setParser(result -> {
			if (result.fail) {
				return result;
			}

			Concatenation concat = new Concatenation();
			concat.child1 = p1.apply(result);
			if (concat.child1.fail) {
				return concat.child1;
			}

			concat.child2 = p2.apply(concat.child1);
			if (concat.child2.fail) {
				return concat.child2;
			}

			concat.unseen = concat.child2.unseen;
			return concat;
		});
		return parser;
	}

	// returns p+
	public static Parser rep(Parser p) {
		Parser parser = new Parser();
		parser.setParser(result -> {
			if (result.fail) {
				return result;
			}

			Iteration rep = new Iteration();

			do {
				rep.kids.add(p.apply(result));
			} while (!result.fail);

			return rep;
		});

		return parser;

	}

	// returns p?
	public static Parser opt(Parser p) {

		Parser parser = new Parser();
		parser.setParser(result -> {

			Option opt = new Option();
			opt.child1 = p.apply(result);
			return opt;

		});
		return parser;

	}

	// returns p = regExp
	public static Parser regEx(String regex) {

		Parser parser = new Parser();
		parser.setParser(result -> {
			if (result.fail) {
				return result;
			}
			Literal answer = new Literal();

			if (result.pending() == 0) {
				result.fail = true;
				return result;
			}

			answer.token = result.unseen.get(0);
			if (answer.token.matches(regex)) {
				answer.unseen = result.unseen.subList(1, result.unseen.size());
			} else {
				answer.fail = true;
				answer.unseen = result.unseen;
			}
			return answer;
		});
		return parser;
	}
	// etc.
}