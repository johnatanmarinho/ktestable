package br.com.johnatan.ktestable;

import java.util.ArrayList;
import java.util.List;

public class KTMachineBuilder {

	public static KTMachine buildKTMachine(int k, List<String> sentences) {
		List<String> prefix = new ArrayList<>();
		List<String> sufix = new ArrayList<>();
		List<String> allowed = new ArrayList<>();
		List<Character> alphabet = new ArrayList<>();
		
		for(String sentence : sentences){
			for(Character c : sentence.toCharArray()){
				if(!alphabet.contains(c)){
					alphabet.add(c);
				}
			}
			
			if(sentence.length() < k){
				prefix.add(sentence);
			}
			
			if(sentence.length() >= k){
				String p = sentence.substring(0, k - 1);
				if(!prefix.contains(p)){
					prefix.add(p);
				}
				String s = sentence.substring(sentence.length() - (k + 1));
				if(!sufix.contains(s)){
					sufix.add(s);
				}
			}
			
			for(int i = 0; i < sentence.length() - (k-1) ; i++){
				String substring = sentence.substring(i, i + k);
				if(!allowed.contains(substring)){
					allowed.add(substring);
				}
			}
		}
		
		return new KTMachine(k, alphabet, prefix, sufix, allowed);
	}

}
