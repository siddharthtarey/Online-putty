package sshpack;

import java.io.Serializable;

public class TUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private String name;
	private String lastname;
	private int code;
	private String ver;
	public int getCode() {
		return code;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public TUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TUser(String email, String password, String name, String lastname,int code,String ver) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.code = code;
		this.ver = "0";
	}
	public TUser(TUser p) {
		super();
		this.email = p.email;
		this.password = p.password;
		this.name = p.name;
		this.lastname = p.lastname;
		this.code = p.code;
		this.ver = "0";
		
	}
	
}
