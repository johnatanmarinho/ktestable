package br.com.johnatan.ktestable;

import java.util.List;

public class Automato {

	private String initialState;
	private List<String> sufix;
	private Transitions transitions;

	public Automato(String string, List<String> sufix, Transitions transitions) {
		this.initialState = string;
		this.sufix = sufix;
		this.transitions = transitions;
	}

	public String getInitialState() {
		return initialState;
	}

	public void setInitialState(String initialState) {
		this.initialState = initialState;
	}

	public List<String> getSufix() {
		return sufix;
	}

	public void setSufix(List<String> sufix) {
		this.sufix = sufix;
	}

	public Transitions getTransitions() {
		return transitions;
	}

	public void setTransitions(Transitions transitions) {
		this.transitions = transitions;
	}

	public boolean recognize(String string) {
		String state = this.initialState;		
		for(Character c : string.toCharArray()){
			String read = transitions.read(state, c);	
			if(read == Transitions.ERROR 
					&& !sufix.contains(read)){
				return false; 
			}
			state = read;
		}
		return true;
	}	
	

}
