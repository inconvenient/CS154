import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArithmeticInterpreter {
	
	public ArithmeticInterpreter() {
		
	}

	public void ui() {
		Boolean validExp = true;
		Scanner in = new Scanner(System.in);

		while (validExp) {
			System.out
					.println("Please enter your arithmetic problem or type Quit to quit: ");
			String prob = in.nextLine();

			Pattern validOp = Pattern.compile("[\\+\\-\\*\\/]"); // Pattern for
																	// valid
																	// operators
			Pattern invalidNum = Pattern.compile("[a-zA-Z]"); // Pattern to find
																// letters in
																// expression
			Matcher OpMatch = validOp.matcher(prob);
			Matcher invNumMatch = invalidNum.matcher(prob);

			if (prob.compareTo("Quit") == 0) {
				validExp = false;
				System.out.println("Goodbye");
				in.close();
			} else if (!OpMatch.find()) { // If the matcher did not find any
											// valid operators (return false),
											// make it true.
				System.out.println("Invalid Operator");
			} else if (invNumMatch.find()) {
				System.out.println("Invalid Numbers");
			} else {
				interpret(prob);
			}
		}
	}

	public void interpret(String p) {
		List<Object> chunks = new ArrayList<Object>();
		String problem = p;
		Double result = null;
		Pattern pt = Pattern.compile("((\\-)?\\d+(.\\d+)?)|[\\+|\\-|\\/|\\*]");
		Matcher mt = pt.matcher(problem);

		while (mt.find()) {
			chunks.add(mt.group()); // Add every chunk of the equation to an arraylist.
		}

		if (chunks.contains("+")) {
			result = Double.parseDouble(chunks.get(0).toString())
					+ Double.parseDouble(chunks.get(2).toString());
		} else if (chunks.contains("-")) {
			result = Double.parseDouble(chunks.get(0).toString())
					- Double.parseDouble(chunks.get(2).toString());
		} else if (chunks.contains("/")) {
			result = Double.parseDouble(chunks.get(0).toString())
					/ Double.parseDouble(chunks.get(2).toString());
		} else if (chunks.contains("*")) {
			result = Double.parseDouble(chunks.get(0).toString())
					* Double.parseDouble(chunks.get(2).toString());
		}
		System.out.println(result);
	}
}
