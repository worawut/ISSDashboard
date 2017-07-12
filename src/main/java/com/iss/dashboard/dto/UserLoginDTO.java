package com.iss.dashboard.dto;

public class UserLoginDTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String sessionId;
	private String pin;
	private String userName;
	private String firstNameThai;
	private String lastNameThai;
	private String firstNameEng;
	private String lastNameEng;
	private String homeAirport;
	private String buildNo;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstNameThai() {
		return firstNameThai;
	}

	public void setFirstNameThai(String firstNameThai) {
		this.firstNameThai = firstNameThai;
	}

	public String getLastNameThai() {
		return lastNameThai;
	}

	public void setLastNameThai(String lastNameThai) {
		this.lastNameThai = lastNameThai;
	}

	public String getFirstNameEng() {
		return firstNameEng;
	}

	public void setFirstNameEng(String firstNameEng) {
		this.firstNameEng = firstNameEng;
	}

	public String getLastNameEng() {
		return lastNameEng;
	}

	public void setLastNameEng(String lastNameEng) {
		this.lastNameEng = lastNameEng;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getHomeAirport() {
		return homeAirport;
	}

	public void setHomeAirport(String homeAirport) {
		this.homeAirport = homeAirport;
	}

	public String getBuildNo() {
		return buildNo;
	}

	public void setBuildNo(String buildNo) {
		this.buildNo = buildNo;
	}
}
