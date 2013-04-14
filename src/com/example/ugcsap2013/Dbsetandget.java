package com.example.ugcsap2013;

public class Dbsetandget {

	private String spin1;
	private int time;
	private String date;
	private String auto1;
	private String spin2;
	private String spin3;
	private String auto2;

	public Dbsetandget(String spin1, int time, String date, String auto1, String spin2,
			String spin3, String auto2) {
		// TODO Auto-generated constructor stub
		this.spin1=spin1;
		this.time=time;
		this.date=date;
		this.auto1=auto1;
		this.spin2=spin2;
		this.spin3=spin3;
		this.auto2=auto2;
	}
	
	public String getSpin1() {
		return spin1;
	}
	public void setSpin1(String spin1) {
		this.spin1 = spin1;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAuto1() {
		return auto1;
	}
	public void setAuto1(String auto1) {
		this.auto1 = auto1;
	}
	public String getAuto2() {
		return auto2;
	}
	public void setAuto2(String auto2) {
		this.auto2 = auto2;
	}
	public String getSpin2() {
		return spin2;
	}
	public void setSpin2(String spin2) {
		this.spin2 = spin2;
	}
	public String getSpin3() {
		return spin3;
	}
	
	public void setSpin3(String spin3) {
		this.spin3 = spin3;
	}

}
