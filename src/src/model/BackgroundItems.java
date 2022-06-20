package model;

import java.io.Serializable;

public class BackgroundItems implements Serializable {
	private int id;
	private String user_id;
	private String background_id;
	private String mail;
	private String bg_name;
	private String bg_image;
	private String background_active;







	//引数があるコンストラクタ
	public BackgroundItems(int id, String user_id, String background_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.background_id = background_id;
	}

	public BackgroundItems( String bg_name, String bg_image, String background_active) {
		super();
		this.bg_name = bg_name;
		this.bg_image = bg_image;
		this.background_active = background_active;
	}

	//登録用コンストラクタ
	public BackgroundItems(String user_id, String background_id) {
		super();
		this.user_id = user_id;
		this.background_id = background_id;
	}

	//
	public BackgroundItems(String mail) {
		super();
		this.mail = mail;

	}

	//引数がないコンストラクタ
	public BackgroundItems() {
		super();
		this.id = 0;
		this.user_id = "";
		this.background_id = "";
	}

	//ゲッターセッター
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

	public String getBackground_id() {
		return background_id;
	}

	public void setBackground_id(String background_id) {
		this.background_id = background_id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getBg_name() {
		return bg_name;
	}

	public void setBg_name(String bg_name) {
		this.bg_name = bg_name;
	}

	public String getBg_image() {
		return bg_image;
	}

	public void setBg_image(String bg_image) {
		this.bg_image = bg_image;
	}

	public String getBackground_active() {
		return background_active;
	}

	public void setBackground_active(String background_active) {
		this.background_active = background_active;
	}

}



