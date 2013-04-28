package com.example.ugcsap2013;

public class Journalpojo {

	String title,pageNo,yop,isbn,date,impFact,noOfAuth,
	 reff,mainAuth;
	
	
	public Journalpojo(String title, String pageNo, String yop, String isbn,
			String date, String impFact, String noOfAuth, String reff,
			String mainAuth) {
		
		this.title = title;
		this.pageNo = pageNo;
		this.yop = yop;
		this.isbn = isbn;
		this.date = date;
		this.impFact = impFact;
		this.noOfAuth = noOfAuth;
		this.reff = reff;
		this.mainAuth = mainAuth;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String getYop() {
		return yop;
	}
	public void setYop(String yop) {
		this.yop = yop;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getImpFact() {
		return impFact;
	}
	public void setImpFact(String impFact) {
		this.impFact = impFact;
	}
	public String getNoOfAuth() {
		return noOfAuth;
	}
	public void setNoOfAuth(String noOfAuth) {
		this.noOfAuth = noOfAuth;
	}
	public String getReff() {
		return reff;
	}
	public void setReff(String reff) {
		this.reff = reff;
	}
	public String getMainAuth() {
		return mainAuth;
	}
	public void setMainAuth(String mainAuth) {
		this.mainAuth = mainAuth;
	}
	
	
	
}
