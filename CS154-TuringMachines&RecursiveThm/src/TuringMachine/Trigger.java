package TuringMachine;

public class Trigger {

	int curState;
	int curCell; // Position of R/W Head

	public Trigger(int cS, int cC) {
		curState = cS;
		curCell = cC;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + curCell;
		result = prime * result + curState;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trigger other = (Trigger) obj;
		if (curCell != other.curCell)
			return false;
		if (curState != other.curState)
			return false;
		return true;
	}

}
