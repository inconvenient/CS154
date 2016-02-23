package TuringMachine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TuringMachine {
	private Tape tape;
	private Map<Trigger, Action> program;
	private Set<Integer> finalStates; // run halts when state is a member
	private int state; // the current state

	public void run() {
		while (!finalStates.contains(state)) {
			Trigger input = new Trigger(this.state, Character.getNumericValue(tape.read()));
			Action a = program.get(input);
			// Action = newState, contentChange, direction
			state = a.getNewState();
			String temp = Integer.toString(a.getContentChange());
			tape.write(temp.charAt(0));
			tape.moveHead(a.getDirection());
		}
		System.out.println(tape.toString());
	}

	public void addProgram(Trigger t, Action a) {
		program.put(t, a);
	}

	public void addFinalStates(int fs) {
		finalStates.add(fs);
	}

	public void setFinalStates() {
		finalStates = new HashSet<Integer>();
	}

	public void setProgram() {
		program = new HashMap<Trigger, Action>();
	}

	public void setState(int s) {
		state = s;
	}

	public void setTape(Tape t) {
		tape = t;
	}
	
	public int getCurrentState() {
		return this.state;
	}
}