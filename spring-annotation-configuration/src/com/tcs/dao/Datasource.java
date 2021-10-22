package com.tcs.dao;

//@Component
//@Scope("prototype")
public class Datasource {
	//@Value("jdbc:mysql://localhost:ip")
	private String url;
	//@Value("admin")
	private String username;
	//@Value("root")
	private String password;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
