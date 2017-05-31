package br.com.johnatan.ktestable;

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
				
		KTMachine machine = KTMachineBuilder.buildKTMachine(k, sentences);
		Automato dfa = AutomatoBuilder.automatoBuilder(machine);

		System.out.println(
				 dfa.recognize("sera que meu k testable funciona") 	
			 		? "sucess" 
			 		: "fail");	
		
	}
}
