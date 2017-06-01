package br.com.johnatan.ktestable;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class AutomatoBuilderTest {

	@Test
	public void test() {
		List<String> sentences = Arrays.asList(
				"testando k testable",
				"k testable sera testado",
				"funcionando k testable deve estar",
				"sera que esta funcionando");
		
		String sampleTrue = "sera testado k testable deve estar";
		String sampleFalse = "ababababababa";
		Automato dfa = AutomatoBuilder.build(4, sentences);
		
		assertTrue(dfa.recognize(sampleTrue));
		assertFalse(dfa.recognize(sampleFalse));
	}

}
