package model;

import java.io.Serializable;

public class Diaries implements Serializable {
	private int id;
	private String user_id;
	private String diary_date;
	private String diary_title;
	private String diary_content;
	private String mail;


	public Diaries(int id, String user_id, String diary_date, String diary_title, String diary_content) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.diary_date = diary_date;
		this.diary_title = diary_title;
		this.diary_content = diary_content;

	}
	//4つのコンストラクタ
	public Diaries( String user_id, String diary_date, String diary_title, String diary_content) {
		super();
		this.user_id = user_id;
		this.diary_date = diary_date;
		this.diary_title = diary_title;
		this.diary_content = diary_content;

	}
//3つのコンストラクタ

	public Diaries( String diary_date, String diary_title, String diary_content) {
		super();

		this.diary_date = diary_date;
		this.diary_title = diary_title;
		this.diary_content = diary_content;
	}


	/*public Diaries( String diary_title, String diary_content) {
		super();

		this.diary_title = diary_title;
		this.diary_content = diary_content;
	}*/

	public Diaries(String diary_date, String diary_title) {
		super();

		this.diary_date = diary_date;
		this.diary_title = diary_title;

	}

	public Diaries(String mail) {
		super();
		this.mail = mail;

	}

		public Diaries() {
			super();
			this.id = 0;
			this.user_id = "";
			this.diary_date ="";
			this.diary_title = "";
			this.diary_content = "";

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
		public String getDiary_date() {
			return diary_date;
		}
		public void setDiary_date(String diary_date) {
			this.diary_date = diary_date;
		}
		public String getDiary_title() {
			return diary_title;
		}
		public void setDiary_title(String diary_title) {
			this.diary_title = diary_title;
		}
		public String getDiary_content() {
			return diary_content;
		}
		public void setDiary_content(String diary_content) {
			this.diary_content = diary_content;
		}
		public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}




}
