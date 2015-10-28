package com.agentplannertool.backend.emailutil;

public class Email {
	private String host;
	private String protocol;
	private String port;
	private String auth;
	private String starttls;
	private String socketFactoryPort;
	private String socketFactoryClass;
	private String socketFactoryFallback;
	private String usrname;
	private String pasword;
	
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String isAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String isStarttls() {
		return starttls;
	}
	public void setStarttls(String starttls) {
		this.starttls = starttls;
	}
	public String getSocketFactoryPort() {
		return socketFactoryPort;
	}
	public void setSocketFactoryPort(String socketFactoryPort) {
		this.socketFactoryPort = socketFactoryPort;
	}
	public String getSocketFactoryClass() {
		return socketFactoryClass;
	}
	public void setSocketFactoryClass(String socketFactoryClass) {
		this.socketFactoryClass = socketFactoryClass;
	}
	public String isSocketFactoryFallback() {
		return socketFactoryFallback;
	}
	public void setSocketFactoryFallback(String socketFactoryFallback) {
		this.socketFactoryFallback = socketFactoryFallback;
	}
	public String getUsername() {
		return usrname;
	}
	public void setUsername(String usrname) {
		this.usrname = usrname;
	}
	public String getPassword() {
		return pasword;
	}
	public void setPasword(String password) {
		this.pasword = pasword;
	}
	
}