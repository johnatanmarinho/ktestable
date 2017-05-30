package br.com.johnatan.ktestable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
	public static void main(String[] args) {
			
		int k = 3;
		List<String> sentences = Arrays.asList(
				"testando meu k testable",
				"sera que meu k testable funciona",
				"o meu k testable é o melhor",
				"o seu k testable é - melhor que o meu");
		List<String> sentences2 = Arrays.asList(
				"a",
				"aa",
				"abba",
				"abbbba");
		
		
		KTMachine machine = KTMachineBuilder.buildKTMachine(k, sentences);
		
		Automato dfa = AutomatoBuilder.automatoBuilder(machine);

		for(String s : machine.getPrefix()){
			System.out.println(s);
		}
		writeTransition(dfa.getTransitions(), machine);
		if(dfa.recognize("testando meu k testable")){
			System.out.println("SUCESS!!!");
		}else {
			System.out.println("=(");
		}
		
	}

	private static void writeTransition(List<Transition> transitions, KTMachine machine) {
		for(Transition t : transitions){
			System.out.println(t.getSource());
			for(Character c : machine.getAlphabet()){
				if(t.read(c) == "ERROR") continue;
				System.out.println(c + " -> " +t.read(c));
			}
			System.out.println("===================");
		}
	}
}
