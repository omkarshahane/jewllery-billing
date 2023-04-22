package com;

public class Customer {
	
	private String cname;
	private int mobile;
	private String address;
	
	public Customer()
	{
		
	}
	

	public Customer(String cname, int mobile, String address) {
		super();
		this.cname = cname;
		this.mobile = mobile;
		this.address = address;
	}


	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

}
