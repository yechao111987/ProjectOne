package com.yechao.dao;

public class Critalfactor {
	private String nameString;
	private String addressString;
	private String phoneString;
	public String getNameString() {
		if (nameString == null) {
			nameString="%%";
		}
		else {
			nameString="%"+nameString+"%";
		}
		return nameString;
	}
	public String getNameString1() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getAddressString() {
		if (addressString==null) {
			addressString="%%";
		}else {
			addressString="%"+addressString+"%";
		}
		return addressString;
	}
	public String getAddressString1() {
		return addressString;
	}
	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}
	public String getPhoneString() {
		if (phoneString==null) {
			phoneString="%%";
		}else {
			phoneString="%"+phoneString+"%";
		}
		return phoneString;
	}
	public String getPhoneString1() {
		return phoneString;
	}
	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}
	public Critalfactor(String nameString, String addressString,
			String phoneString) {
		super();
		this.nameString = nameString;
		this.addressString = addressString;
		this.phoneString = phoneString;
	}
	@Override
	public String toString() {
		return "Critalfactor [nameString=" + nameString + ", addressString="
				+ addressString + ", phoneString=" + phoneString + "]";
	}
	
	
	

}
