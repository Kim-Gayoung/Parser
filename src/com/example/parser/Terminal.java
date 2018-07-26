package com.example.parser;

public class Terminal {
	private String syntax;
	private Token token;
	private int front;
	private int end;
	
	public Terminal() {
		
	}
	public Terminal(String syntax, Token token, int front, int end) {
		this.syntax = syntax;
		this.token = token;
		this.front = front;
		this.end = end;
	}

	public String getSyntax() {
		return syntax;
	}

	public void setSyntax(String syntax) {
		this.syntax = syntax;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public int getFront() {
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return syntax;
	}
}
