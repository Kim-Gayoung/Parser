package com.example.parser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class LexerTest {

	void test() {
		InputStreamReader isr = new InputStreamReader(System.in);
		LexicalAnalyzer lexical = new LexicalAnalyzer(isr);
		try {
			ArrayList<Terminal> terminals = lexical.Lexing();
			for (Terminal t: terminals) {
				System.out.println(t.toString() + " " + t.getToken());
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
