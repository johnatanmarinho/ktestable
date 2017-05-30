package br.com.johnatan.ktestable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transitions {
	public static final String ERROR = "ERROR";
	private Map<String, Map<Character, String>> transition; // Map<estado, Map<leitura, saida>>

	public Transitions(List<String> states, List<Character> alphabet){
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
			this.transition.get(source).put(c, destination);
		}
	}
	
	public Map<String, Map<Character, String>> getTransitions(){
		return this.transition;
	}
}
