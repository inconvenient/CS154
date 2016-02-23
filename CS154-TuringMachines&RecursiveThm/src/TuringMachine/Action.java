package TuringMachine;

public class Action {

	int newState;
	int contentChange;
	int direction;

	public Action(int nS, int cC, int d) {
		newState = nS;
		contentChange = cC;
		direction = d;
	}

	public int getNewState() {
		return newState;
	}

	public int getContentChange() {
		return contentChange;
	}

	public int getDirection() {
		return direction;
	}

}
