package com.example.parser;

public class NonTerminal extends Stkelem {
	private Object tree;

	public NonTerminal(Object tree) {
		super();
		this.tree = tree;
	}

	public Object getTree() {
		return tree;
	}

	public void setTree(Object tree) {
		this.tree = tree;
	}

}
