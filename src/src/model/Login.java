package model;

import java.io.Serializable;

public class Login implements Serializable {


	private String mail;	// ログイン時のID

	public Login() {
		this(null);
	}

	public Login(String mail) {
		this.mail = mail;
	}

	public String getId() {
		return mail;
	}

	public void setUserId(String mail) {
		this.mail = mail;
	}
}


