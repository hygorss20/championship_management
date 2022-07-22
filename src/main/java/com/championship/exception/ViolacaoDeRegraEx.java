package com.championship.exception;

public class ViolacaoDeRegraEx extends RuntimeException{

	private static final long serialVersionUID = 1913787110540571538L;
	
	public ViolacaoDeRegraEx() {
	}

	public ViolacaoDeRegraEx(Throwable e) {
		super(e);
	}

	public ViolacaoDeRegraEx(String message) {
		super(message);
	}

	public ViolacaoDeRegraEx(String message, Throwable e) {
		super(message, e);
	}
}
