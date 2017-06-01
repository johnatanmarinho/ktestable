package br.com.johnatan.ktestable;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class KTMachineBuilderTest {

	@Test
	public void initialStateTest() {

		List<String> sentences = Arrays.asList(
				"a",
				"aa",
				"abba",
				"abbbba"
				);
		String[] initialStates = {"a", "aa", "ab"};	
		String[] finalStates = {"a", "aa", "ba"};
		String[] allowedStrings = {"abb", "bba", "bbb"};	
		
		KTMachine machine = KTMachineBuilder.buildKTMachine(3, sentences);
		
		assertArrayEquals(initialStates, machine.getInitialStates().toArray());
		assertArrayEquals(finalStates, machine.getSufix().toArray());
		assertArrayEquals(allowedStrings, machine.getAllowedString().toArray());

	}
}
