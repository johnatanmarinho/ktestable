package br.com.johnatan.ktestable;

import java.util.ArrayList;
import java.util.List;

public class AutomatoBuilder {

	static Automato automatoBuilder(KTMachine machine) {
		List<String> states = new ArrayList<>();
		List<Transition> transitions = new ArrayList<>();
		states.add(">");
		states.add("ERROR");
		
		getStateFromPrefix(machine, states);
		
		getStateFromSegment(machine, states);
		
		initializeTransitions(transitions, machine, states);
		
		createTransitions(transitions, machine);
		return new Automato(">",machine.getSufix(), transitions);
	}

	private static void createTransitions(List<Transition> transitions, KTMachine machine) {
		for(String str : machine.getPrefix()){
			if(str == ">" || str == "ERROR"){
				continue;
			}
			for (int i = 0; i < str.length() ; i++) {
				Character c = str.charAt(i);
				String source = ">"; 
				if(i != 0){
					source = str.substring(0, i);
				}
				String destination = str.substring(0, i+1);
				getTransition(transitions, source).put(c, destination);
			}	
		}
		
		for(String str :  machine.getAcceptable()){
			if(str.length() < 2){
				continue;
			}
			String source = str.substring(0,str.length()-1);
			String destination = str.substring(1, str.length());
			Character c = str.charAt(str.length()-1);
			getTransition(transitions, source).put(c, destination);
		}
	}

	private static void initializeTransitions(List<Transition> transitions, KTMachine machine, List<String> states) {
		for(String str : states){						//initialize all transitions with error state
			Transition transition = new Transition(str);
			for(Character c : machine.getAlphabet()){
				transition.put(c, "ERROR");
			}
			transitions.add(transition);
		}
	}

	private static void getStateFromSegment(KTMachine machine, List<String> states) {
		for(String str : machine.getAcceptable()){	// for every possible str get a sub string with lenght k - 1
			if(str.length() > 1){
				String prefix = str.substring(0, str.length()-1);				
				String sufix = str.substring(1, str.length());
				if(!states.contains(prefix)){
					states.add(prefix);					
				}
				if(!states.contains(sufix)){
					states.add(sufix);
				}
			} 
		}
	}

	private static void getStateFromPrefix(KTMachine machine, List<String> states) {
		for(String i : machine.getPrefix()){ // all prefixes are states 
			if(!states.contains(i)){
				states.add(i);
			}
		}
	}

	private static Transition getTransition(List<Transition> transitions, String source){
		for (Transition transition : transitions) {
			if(transition.getSource().equals(source)){
				return transition;
			}
		}
		return new Transition("ERROR");
	}

}
