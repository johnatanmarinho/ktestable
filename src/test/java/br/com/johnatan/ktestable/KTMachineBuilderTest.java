package br.com.johnatan.ktestable;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class KTMachineBuilderTest {

	@Test
	public void initialStateTest() {

		List<String> dataSet = Arrays.asList(
				"a",
				"aa",
				"abba",
				"abbbba"
				);
		String[] initialStates = {"a", "aa", "ab"};		
		KTMachine machine = KTMachineBuilder.buildKTMachine(3, dataSet);

		assertArrayEquals(machine.getPrefix().toArray(), initialStates);
	}
	
	@Test
	public void allowedStringTest() {
		List<String> dataSet = Arrays.asList(
				"a",
				"aa",
				"abba",
				"abbbba"
		);
		String[] allowedStrings = {"abb", "bbb", "bba"};
		KTMachine machine = KTMachineBuilder.buildKTMachine(3, dataSet);
		assertArrayEquals(machine.getAcceptable().toArray(), allowedStrings );

	}
	
	@Test	
	public void finalStatesTest() {
		String[] finalStates = {
			"a",
			"aa",
			"ba"			
		};
		List<String> dataSet = Arrays.asList(
				"a",
				"aa",
				"abba",
				"abbbba"
				);
		KTMachine machine = KTMachineBuilder.buildKTMachine(3, dataSet);

		assertArrayEquals(machine.getSufix().toArray(), finalStates);
	}

}
