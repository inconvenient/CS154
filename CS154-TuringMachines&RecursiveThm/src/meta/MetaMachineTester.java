package meta;

public class MetaMachineTester {
	public static void main(String args[]) throws Exception {
		MetaMachine mm = new MetaMachine();
		// mm.execute("meta.Greeter", "greetings", "Hello", "Jupiter");
		mm.execute("meta.MetaMachine", "execute", "meta.Greeter", "greetings", "Hello", "Jupiter");
	}
}
