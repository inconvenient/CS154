package TuringMachine;

public class TMTester {

	public static void main(String[] args) {

		TuringMachine tm = new TuringMachine();
		tm.setProgram();
		
		tm.addProgram(new Trigger(0, 1), new Action(0, 1, 1));
		tm.addProgram(new Trigger(0, 0), new Action(1, 0, 1));
		tm.addProgram(new Trigger(1, 0), new Action(3, 0, 0));
		tm.addProgram(new Trigger(1, 1), new Action(2, 0, -1));
		tm.addProgram(new Trigger(2, 0), new Action(0, 1, 1));
		tm.addProgram(new Trigger(2, 1), new Action(4, 1, 0));
		
		tm.setState(0);
		tm.setFinalStates();
		tm.addFinalStates(3); // Complete
		tm.addFinalStates(4); // Error
		tm.setTape(new Tape("1111101111110"));

		System.out.println("Addition TM: 5 + 6");
		tm.run();
		
		System.out.println("--------------------------");
		
		TuringMachine tm2 = new TuringMachine();
		tm2.setProgram();
		
		tm2.addProgram(new Trigger(0, 0), new Action(1, 0, 1));
		tm2.addProgram(new Trigger(0, 1), new Action(2, 0, 1));
		tm2.addProgram(new Trigger(1, 0), new Action(14, 0, 1));
		tm2.addProgram(new Trigger(1, 1), new Action(2, 0, 1));
		tm2.addProgram(new Trigger(2, 0), new Action(3, 0, 1));
		tm2.addProgram(new Trigger(2, 1), new Action(2, 1, 1));
		tm2.addProgram(new Trigger(3, 0), new Action(15, 0, -1));
		tm2.addProgram(new Trigger(3, 1), new Action(4, 0, 1));
		tm2.addProgram(new Trigger(4, 0), new Action(5, 0, 1));
		tm2.addProgram(new Trigger(4, 1), new Action(4, 1, 1));
		tm2.addProgram(new Trigger(5, 0), new Action(6, 1, -1));
		tm2.addProgram(new Trigger(5, 1), new Action(5, 1, 1));
		tm2.addProgram(new Trigger(6, 0), new Action(7, 0, -1));
		tm2.addProgram(new Trigger(6, 1), new Action(6, 1, -1));
		tm2.addProgram(new Trigger(7, 0), new Action(9, 1, -1));
		tm2.addProgram(new Trigger(7, 1), new Action(8, 1, -1));
		tm2.addProgram(new Trigger(8, 0), new Action(3, 1, 1));
		tm2.addProgram(new Trigger(8, 1), new Action(8, 1, -1));
		tm2.addProgram(new Trigger(9, 0), new Action(10, 0, -1));
		tm2.addProgram(new Trigger(9, 1), new Action(9, 1, -1));
		tm2.addProgram(new Trigger(10, 0), new Action(12, 0, 1));
		tm2.addProgram(new Trigger(10, 1), new Action(11, 1, -1));
		tm2.addProgram(new Trigger(11, 0), new Action(0, 0, 1)); 
		tm2.addProgram(new Trigger(11, 1), new Action(11, 1, -1));
		tm2.addProgram(new Trigger(12, 0), new Action(12, 0, 1));
		tm2.addProgram(new Trigger(12, 1), new Action(13, 0, 1));
		tm2.addProgram(new Trigger(13, 0), new Action(14, 0, 1));
		tm2.addProgram(new Trigger(13, 1), new Action(13, 0, 1));
		
		tm2.setState(0);
		tm2.setFinalStates();
		tm2.addFinalStates(14);
		tm2.setTape(new Tape("11011110")); // 2 * 4
		
		System.out.println("Multiplication TM: 2 * 4");
		tm2.run();
		
		System.out.println("--------------------------");
		
		TuringMachine tm3 = new TuringMachine();
		tm3.setProgram();
		tm3.addProgram(new Trigger(0, 1), new Action(0, 1, 1));
		tm3.addProgram(new Trigger(0, 0), new Action(1, 0, 1));
		tm3.addProgram(new Trigger(1, 0), new Action(1, 0, 1));
		tm3.addProgram(new Trigger(1, 1), new Action(2, 1, 1));
		tm3.addProgram(new Trigger(2, 1), new Action(2, 1, 1));
		tm3.addProgram(new Trigger(2, 0), new Action(3, 0, 1));
		tm3.addProgram(new Trigger(3, 0), new Action(4, 0, 1));
		tm3.addProgram(new Trigger(3, 1), new Action(5, 1, 1));
		
		tm3.setState(0);
		tm3.setFinalStates();
		tm3.addFinalStates(4); // Halt (SUCCESS)
		tm3.addFinalStates(5); // Error (FAIL)
		tm3.setTape(new Tape("111000111"));
		
		System.out.println("1n0n1n TM: 111000111 [Success = 4 / Fail = 5]");
		tm3.run();
		System.out.println("Final State: " + tm3.getCurrentState());
		
	}
}
