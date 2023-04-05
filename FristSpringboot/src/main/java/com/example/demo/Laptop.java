package com.example.demo;

public class Laptop {
	private int lid;
	private String lnmae;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLnmae() {
		return lnmae;
	}
	public void setLnmae(String lnmae) {
		this.lnmae = lnmae;
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lnmae=" + lnmae + "]";
	}
	
	public void compile()
	{
		System.out.println("compiling");
	}

}
