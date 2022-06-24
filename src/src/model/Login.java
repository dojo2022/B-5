package model;

import java.io.Serializable;

public class Login implements Serializable {


	private String mail;	// ログイン時のID
	private String pw;
	private String user_id;
	private int point_value;


	public Login() {
		this(null);
	}

	public Login(String mail) {
		this.mail = mail;
	}

	public Login(String mail,String pw,String user_id,int point_value) {
		this.mail = mail;
		this.pw = pw;
		this.user_id = user_id;
		this.point_value=point_value;
	}

	public Login(String mail,String pw,String user_id) {
		this.mail = mail;
		this.pw = pw;
		this.user_id = user_id;
	}

	public Login(String mail,int point_value) {
		this.mail = mail;
		this.point_value = point_value;
	}


	public int getPoint_value() {
		return point_value;
	}

	public void setPoint_value(int point_value) {
		this.point_value = point_value;
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


