import java.util.HashMap;

public class FSM {

	int state = 0;
	int finalState = 0;
	HashMap<State, Integer> states = new HashMap<State, Integer>();

	void addTransition(char token, int state, int nextState) {
		// State is Key. nextState is Value.
		states.put(new State(token, state), nextState);
	}

	// PROFESSOR'S SOLUTIONS
	/* private void move(char token) {
		State config = new State(token, state);
		if (states.containsKey(config)) {
			state = states.get(config);
		} else {
			state = -1; // dead state
		}
	}
	
	public boolean accept(String input) {
		state = 0;
		for(int i = 0; i < input.length(); i++) {
			move(input.charAt(i));
		}
		if(finalState == state) {
			return true;
		} else return false;
		// return finalStates.contains(state);
	} */

	 boolean accept(String s) {
		// if no transition is specified, then state = -1 (dead state)
		String input = s;
		int ptr = 0;

		while (ptr <= input.length() - 1 && state != -1) {
			char temp = s.charAt(ptr);
			State checkState = new State(temp, state);
			if (states.containsKey(checkState)) {
				state = states.get(checkState);
				ptr++;
			} else
				state = -1;
		}

		if (state == finalState) {
			state = 0;
			return true;
		} else if (state != -1) {
			state = 0;
			return true;
		}
		state = 0;
		return false;
	}

	void addFinalState(int state) {
		finalState = state;
	}

	void reset() {
		states.clear();
		state = 0;
		finalState = 0;
	}
}