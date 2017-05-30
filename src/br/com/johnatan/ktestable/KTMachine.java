package br.com.johnatan.ktestable;

import java.util.List;

public class KTMachine {

	private List<String> acceptable;
	private List<String> sufix;
	private List<String> prefix;
	private List<Character> alphabet;
	private int k;

	public KTMachine(int k, List<Character> alphabet, 
							List<String> prefix, 
							List<String> sufix, 
							List<String> acceptable) {
		this.k = k;
		this.alphabet = alphabet;
		this.prefix = prefix;
		this.sufix = sufix;
		this.acceptable = acceptable;
	}

	public List<String> getAcceptable() {
		return acceptable;
	}

	public void setAcceptable(List<String> acceptable) {
		this.acceptable = acceptable;
	}

	public List<String> getSufix() {
		return sufix;
	}

	public void setSufix(List<String> sufix) {
		this.sufix = sufix;
	}

	public List<String> getPrefix() {
		return prefix;
	}

	public void setPrefix(List<String> prefix) {
		this.prefix = prefix;
	}

	public List<Character> getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(List<Character> alphabet) {
		this.alphabet = alphabet;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}
	
	
	

}
