package br.com.johnatan.ktestable;

import java.util.ArrayList;
import java.util.List;

public class AutomatoBuilder {

	static Automato automatoBuilder(KTMachine machine) {
		List<String> states = new ArrayList<>();
		states.add(">");
		states.add("ERROR");
		
		getStateFromPrefix(machine, states);
		
		getStateFromSegment(machine, states);

		Transitions transitions = new Transitions(states, machine.getAlphabet());
		
		createTransitions(transitions, machine);
		
		for(String state : states){
			for(Character c : machine.getAlphabet()){
				if(transitions.read(state, c) != Transitions.ERROR){
					System.out.println( state + ": " + c + " -> " + transitions.read(state, c));
				}
			}
		}
		return new Automato(">",machine.getSufix(), transitions);
	}

	private static void createTransitions(Transitions transitions, KTMachine machine) {
		for(String str : machine.getPrefix()){
			if(str == ">" || str == "ERROR"){
				continue;
			}
			for (int i = 0; i < str.length() ; i++) {
				Character c = str.charAt(i);
				String source = ">"; 
				if(i != 0){
					source = str.substring(0 , i);
				}
				String destination = str.substring(0, i+1);
				transitions.setTransition(source, c, destination);
			}	
		}
		
		for(String str :  machine.getAcceptable()){
			if(str.length() < 2){
				continue;
			}
			String source = str.substring(0,str.length()-1);
			String destination = str.substring(1, str.length());
			Character c = str.charAt(str.length()-1);
			transitions.setTransition(source, c, destination);
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

}
