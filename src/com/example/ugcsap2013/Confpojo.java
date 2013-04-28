package com.example.ugcsap2013;

public class Confpojo {

	String title,pageNo,yop,isbn,date,time,loc,noOfAuth,mainAuth;
	
	

	public Confpojo(String title, String pageNo, String yop, String isbn,
			String date, String time, String loc, String noOfAuth,
			String mainAuth) {
		
		this.title = title;
		this.pageNo = pageNo;
		this.yop = yop;
		this.isbn = isbn;
		this.date = date;
		this.time = time;
		this.loc = loc;
		this.noOfAuth = noOfAuth;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getNoOfAuth() {
		return noOfAuth;
	}

	public void setNoOfAuth(String noOfAuth) {
		this.noOfAuth = noOfAuth;
	}

	public String getMainAuth() {
		return mainAuth;
	}

	public void setMainAuth(String mainAuth) {
		this.mainAuth = mainAuth;
	}
	
	
	
	
	
	
}
