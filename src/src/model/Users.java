package model;

public class Users {
	private int id;
	private String user_id;
	private String user_name;
	private String mail;
	private String login_pw;
	private int point_value;


	public Users(int id, String user_id, String user_name, String mail, String login_pw, int point_value) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.user_name = user_name;
		this.mail = mail;
		this.login_pw = login_pw;
		this.point_value = point_value;

	}

	public Users( String user_id, String user_name, String mail, String login_pw, int point_value) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.mail = mail;
		this.login_pw = login_pw;
		this.point_value = point_value;

	}
	//引数3つのコンストラクタ
	public Users(String user_name, String mail, String login_pw) {
		super();
		this.user_name = user_name;
		this.mail = mail;
		this.login_pw = login_pw;

	}
	//引数2つのコンストラクタ
	public Users(String mail, String login_pw) {
		super();
		this.mail = mail;
		this.login_pw = login_pw;

	}

	//引数２つのコンストラクタ
	public Users(String user_id, int point_value) {
		super();
		this.user_id = user_id;
		this.point_value = point_value;
	}

	public Users(int point_value ,String mail) {
		super();
		this.point_value = point_value;
		this.mail = mail;

	}
	//引数1つのコンストラクタ
		public Users(String mail) {
			super();
			this.mail = mail;

		}

		public Users(int point_value) {
			super();
			this.point_value = point_value;
		}
	public Users() {
		super();
		this.id = 0;
		this.user_id = "";
		this.user_name ="";
		this.mail = "";
		this.login_pw = "";
		this.point_value= 0;

	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getLogin_pw() {
		return login_pw;
	}

	public void setLogin_pw(String login_pw) {
		this.login_pw = login_pw;
	}

	public int getPoint_value() {
		return point_value;
	}

	public void setPoint_value(int point_value) {
		this.point_value = point_value;
	}

}
