package com.example.parser;

public class ParenExpr {
	private Expr expr;

	public ParenExpr(Expr expr) {
		super();
		this.expr = expr;
	}

	public Expr getExpr() {
		return expr;
	}

	public void setExpr(Expr expr) {
		this.expr = expr;
	}
	
}
