package com.example.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Parser {
	private ArrayList<Terminal> lexer;
	private Token currentTok;
	private Stack<State> stack;
	
	private ArrayList<String> parsing_table;
	private ArrayList<String> state_table;
	private HashMap<Integer, String> grammer_rules;
	
	
	public Parser(LexicalAnalyzer lexicalAnalyzer) throws IOException {
		lexer = lexicalAnalyzer.Lexing();
		stack = new Stack<>();
		
		parsing_table = new ArrayList<>();
		state_table = new ArrayList<>();
		grammer_rules = new HashMap<>();
		
		readInitialize();
	}
	
	public void readInitialize()  throws IOException {
		FileReader grammerFReader = new FileReader("grammer_rules.txt");
		FileReader parsingFReader = new FileReader("parsing_table.txt");
		FileReader stateFReader = new FileReader("state_table.txt");
		
		BufferedReader grammerBReader = new BufferedReader(grammerFReader);
		BufferedReader parsingBReader = new BufferedReader(parsingFReader);
		BufferedReader stateBReader = new BufferedReader(stateFReader);
		
		String tmpLine;
		
		while ((tmpLine = grammerBReader.readLine()) != null) {
			// grammerNumber: grammer
			String[] arr = tmpLine.split(":");
			
			int grammerNum = Integer.parseInt(arr[0].trim());
			String grammer = arr[1].trim();
			
			grammer_rules.put(grammerNum, grammer);
		}
		
		while ((tmpLine = parsingBReader.readLine()) != null) {
			parsing_table.add(tmpLine);
		}
		
		while ((tmpLine = parsingBReader.readLine()) != null) {
			state_table.add(tmpLine);
		}
	}
	
	public NonTerminal Parsing() throws FileNotFoundException {
		stack.clear();
		stack.push(new ParseState("S0"));
		
		while (true) {
			ParseState currentState = (ParseState) stack.lastElement();
			Terminal currentTerminal = new Terminal();
			
			if (!lexer.isEmpty()) {
				currentTerminal = lexer.get(0);
			}
			
			if (currentTerminal.getToken() == Token.NONE) {
				return null;
			}
			
			
		}
	}
}
