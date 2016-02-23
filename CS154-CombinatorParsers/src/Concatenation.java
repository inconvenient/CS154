public class Concatenation extends Result {

	protected Result child1, child2;

	// Constructor
	public Concatenation() {

	}
	
	@Override
	public String toString() {
		return "[" + child1 + "] " + " [" + child2 + "]";
	}

}
