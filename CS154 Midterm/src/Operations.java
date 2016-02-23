import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Operations {

	public static List<String> filter(List<String> tokens, Predicate<String> test) {
		List<String> result = new ArrayList<String>();
		for (String e : result) {
			if (test.test(e)) {
				result.add(e);
			}
		}
		return result; // list of all tokens that pass
	}

	public static void main(String args[]) {
		List<String> input = new ArrayList<String>();
		Pattern valid = Pattern.compile("[A-Za-z0-9]");
		Predicate<String> test = 
	}
}