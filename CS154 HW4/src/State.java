public class State {
	char Token;
	int State;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + State;
		result = prime * result + Token;
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
		State other = (State) obj;
		if (State != other.State)
			return false;
		if (Token != other.Token)
			return false;
		return true;
	}

	public State(char tkn, int state) {
		this.Token = tkn;
		this.State = state;
	}

	public boolean compareStates(State s) {
		if (this.State == s.State) {
			if (this.Token == s.Token) {
				return true;
			}
		}
		return false;
	}

}
