package com.yechao.module;

public class User {
	private String useridString;
	private String usernameString;
	private String passwdString;
	
	public String getUseridString() {
		return useridString;
	}

	public void setUseridString(String useridString) {
		this.useridString = useridString;
	}

	public String getUsernameString() {
		return usernameString;
	}

	public void setUsernameString(String usernameString) {
		this.usernameString = usernameString;
	}

	public String getPasswdString() {
		return passwdString;
	}

	public void setPasswdString(String passwdString) {
		this.passwdString = passwdString;
	}

	@Override
	public String toString() {
		return "User [useridString=" + useridString + ", usernameString="
				+ usernameString + ", passwdString=" + passwdString + "]";
	}
	

}
