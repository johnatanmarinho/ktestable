package br.com.johnatan.ktestable;

import java.util.List;

public class Automato {

	private String initialState;
	private List<String> sufix;
	private List<Transition> transitions;

	public Automato(String string, List<String> sufix, List<Transition> transitions) {
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

	public List<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}

	public boolean recognize(String string) {
		String state = this.initialState;
		for(Character c : string.toCharArray()){
			String read = getTransition(state).read(c);
			System.out.println(state);
			if(read == "ERROR" 
					&& !sufix.contains(read)){
				return false; 
			}
			state = read;
		}
		return true;
	}
	
	private Transition getTransition(String state){
		for (Transition transition : transitions) {
			if(transition.getSource().equals(state)){
				return transition;
			}
		}
		return new Transition("ERROR");
	}
	

}
