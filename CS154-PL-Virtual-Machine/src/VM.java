import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class VM {

	private int pc = 0; // program counter
	private Map<String, Integer> vars = new HashMap<String, Integer>();
	private ArrayList<Command> program = new ArrayList<Command>();

	public void add(String cmmd) {
		program.add(new Command(cmmd, pc++));
	}

	private void resolveLabels() {
		Stack<Command> loopStack = new Stack<Command>();
		Map<String, Integer> targets = new HashMap<String, Integer>();
		// pass 1
		for (Command cmmd : program) {
			if (cmmd.getLabel() != null) {
				targets.put(cmmd.getLabel(), cmmd.getPC());
			} else if (cmmd.getOpCode().equals("loop")) {
				loopStack.push(cmmd);
			} else if (cmmd.getOpCode().equals("end")) {
				Command loopCmd = loopStack.pop();
				loopCmd.setTarget(cmmd.getPC());
				cmmd.setTarget(loopCmd.getPC());
			}
		}
		// pass 2
		for (Command cmmd : program) {
			if (cmmd.getOpCode().equals("goto")) {
				// search targets for the pc of this cmmd's label
				int pc = targets.get(cmmd.getArg1());
				cmmd.setTarget(pc);
			}
		}
	}

	public void compile(String fileName) {
		try {
			File file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				add(line);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void execute(Command cmmd) {
		if (cmmd.getOpCode().equals("load")) {
			if(isNumeric(cmmd.getArg2())) {
				vars.put(cmmd.getArg1(), Integer.parseInt(cmmd.getArg2()));
			} else {
				vars.put(cmmd.getArg1(), vars.get(cmmd.getArg2()));
			}
			
		} else if (cmmd.getOpCode().equals("inc")) {
			int result = vars.get(cmmd.getArg1());
			result++;
			vars.put(cmmd.getArg1(), result);
		} else if (cmmd.getOpCode().equals("goto")) {
			pc = cmmd.getTarget() - 1; // -1 to account for pc++ after execution
		} else if (cmmd.getOpCode().equals("loop")) {
			if (isNumeric(cmmd.getArg1())) {
				cmmd.setCount(Integer.parseInt(cmmd.getArg1()));
				if (cmmd.getCount() <= 0) {
					pc = cmmd.getTarget() + 1;
				}
			} else {
				cmmd.setCount(vars.get(cmmd.getArg1()));
				if (cmmd.getCount() <= 0) {
					pc = cmmd.getTarget() + 1;
				}
			}
		} else if (cmmd.getOpCode().equals("end")) {
			Command loop = program.get(cmmd.getTarget());
			loop.setCount(loop.getCount()-1);
			if(loop.getCount() <= 0) {
				pc = loop.getTarget();
			} else pc = loop.getPC();
			
		} else {
			System.out.println("Error: Unrecognized OpCode.");
		}
		for (Map.Entry<String,Integer> entry : vars.entrySet()) {
			  String key = entry.getKey();
			  int value = entry.getValue();
			  System.out.println("Key: " + key + " | Value: " + value);
			}
		System.out.println("PC: " + pc);
	}

	public void run() throws Exception {
		resolveLabels();
		pc = 0;
		int executions = 0;
		while (pc < program.size()) {
			System.out.println(program.get(pc));
			execute(program.get(pc));
			executions++;
			pc++;
		}
		System.out.println("Total variables used: " + vars.size());
		System.out.println("Total executions: " + executions);
	}

	// Helper Methods
	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional
												// '-' and decimal.
	}

}
