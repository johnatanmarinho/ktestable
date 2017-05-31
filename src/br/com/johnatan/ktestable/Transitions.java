package br.com.johnatan.ktestable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transitions {
	public static final String ERROR = "ERROR";
	private Map<String, Map<Character, String>> transition; // Map<estado, Map<leitura, saida>>
	private List<String> states;
	private List<Character> alphabet;

	public Transitions(List<String> states, List<Character> alphabet){
		this.states = states;
		this.alphabet = alphabet;
		this.transition = new HashMap<>();
		
		for(String state : states){
			Map<Character, String> transition = new HashMap<Character, String>();
			for(Character c : alphabet){
				transition.put(c, ERROR);
			}
			this.transition.put(state, transition);
		}
	}
	
	public String read(String source, Character c){
		if(transition.containsKey(source)){
			if(transition.get(source).containsKey(c)){
				return transition.get(source).get(c);				
			}			
		}		
		return Transitions.ERROR;
	}
	public void setTransition(String source, Character c, String destination ){
		if(transition.containsKey(source)){
			if(transition.get(source).containsKey(c)){
				transition.get(source).put(c, destination) ;
			}
		}else{
			Map<Character, String> aux = new HashMap<>();
			aux.put(c, destination);
			transition.put(source, aux);
		}
	}
	
	public Map<String, Map<Character, String>> getTransitions(){
		return this.transition;
	}
	
	@Override
	public String toString() {
		String r = "";
		for(String state : states){
			for(Character c : alphabet){
				r += " state: " + state + " readig: " + c + " goes to " + read(state, c) + "\n";
			}
		}
		return r;
	}
}
