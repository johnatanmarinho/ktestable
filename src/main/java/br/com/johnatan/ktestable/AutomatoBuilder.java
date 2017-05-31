package br.com.johnatan.ktestable;

import java.util.ArrayList;
import java.util.List;

public class AutomatoBuilder {

	static Automato automatoBuilder(KTMachine machine) {
		List<String> states = new ArrayList<>();
		states.add(">");
		states.add(Transitions.ERROR);
		
		getStateFromPrefix(machine, states);
		getStateFromSegment(machine, states);
		Transitions transitions = new Transitions(states, machine.getAlphabet());
		createTransitions(transitions, machine);

		return new Automato(">", machine.getSufix(), transitions);
	}

	private static void createTransitions(Transitions transitions, KTMachine machine) {
		
		for(String str : machine.getPrefix()){
			if(str == ">" || str == Transitions.ERROR){
				continue;
			}
			
			for (int i = 0; i < str.length() ; i++) {
				String source = ">"; 
				if(i != 0){
					source = str.substring(0 , i);
				}else{}
				Character c = str.charAt(i);
				String destination = str.substring(0, i + 1);
				transitions.setTransition(source, c, destination);
			}
			String source = str.substring(0, str.length() - 1);
			Character c = str.charAt(str.length() - 1);
			String destination = str;
			transitions.setTransition(source, c, destination);
		}
		
		for(String str :  machine.getAcceptable()){
			if(str.length() < 2){
				continue;
			}
			String source = str.substring(0, str.length() - 1);
			String destination = str.substring(1);
			Character c = str.charAt(str.length() - 1);
			transitions.setTransition(source, c, destination);
		}
	}


	private static void getStateFromSegment(KTMachine machine, List<String> states) {
		for(String str : machine.getAcceptable()){
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
