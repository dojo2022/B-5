package model;

import java.io.Serializable;

public class Login implements Serializable {


	private String mail;	// ログイン時のID
	private String pw;
	private String user_id;

	public Login() {
		this(null);
	}

	public Login(String mail) {
		this.mail = mail;
	}
	public Login(String mail,String pw,String user_id) {
		this.mail = mail;
		this.pw = pw;
		this.user_id = user_id;
	}


	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


}


