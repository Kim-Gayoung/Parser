package com.example.parser.test;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.example.parser.LexerException;
import com.example.parser.LexicalAnalyzer;
import com.example.parser.Terminal;

class LexerTest {

	@Test
	void test() {
		StringReader sr = new StringReader("123 +  xyz34 * (456 + abc5)");
		LexicalAnalyzer lexical = new LexicalAnalyzer(sr);
		try {
			ArrayList<Terminal> terminals = lexical.Lexing();
			for (Terminal t: terminals) {
				System.out.println(t.toString() + " " + t.getToken());
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (LexerException e) {
			e.printStackTrace();
		}
	}

}
