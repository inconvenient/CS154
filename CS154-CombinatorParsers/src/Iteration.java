import java.util.ArrayList;
import java.util.List;

public class Iteration extends Result {

	protected List<Result> kids;

	public Iteration() {
		kids = new ArrayList<Result>();
	}
	
	@Override
	public String toString() {
		if (this.fail) {
			return super.toString();
		} else return "[" + kids.toString() + "]";
	}

}
