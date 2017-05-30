package br.com.johnatan.ktestable;

import java.util.HashMap;
import java.util.Map;

public class Transition {
	private String source;
	private Map<Character, String> transition;
	
	public Transition(String source){
		this.setSource(source);
		this.transition = new HashMap<>();
	} 
	
	public void put(Character letter, String destination){
		transition.put(letter, destination);
	}
	public String read(Character read){
		return transition.get(read);
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public boolean equals(Object obj) {
		return source.equals(obj) ;
	}
	
}
