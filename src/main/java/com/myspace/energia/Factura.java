package com.myspace.energia;

import java.io.Serializable;

public class Factura implements Serializable {

	private static final long serialVersionUID = 1567974404889996514L;
	
	private String type;

	public Factura() {
		super();
	}
	
	public Factura(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
