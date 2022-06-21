package model;

import java.io.Serializable;

public class KakugenItems implements Serializable {
	public int id;
	public String user_id;
	public String kakugen_id;
	public String kakugen_active;
	public String genre_name;
	public String kakugen_image;
	public String mail;

	//引数があるコンストラクタ
	public KakugenItems(int id, String user_id, String kakugen_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.kakugen_id = kakugen_id;
	}

	//登録用コンストラクタ
	public KakugenItems(String user_id, String kakugen_id) {
		super();
		this.user_id = user_id;
		this.kakugen_id = kakugen_id;
	}

	//引数がないコンストラクタ
	public KakugenItems() {
		super();
		this.id = 0;
		this.user_id = "";
		this.kakugen_id = "";
	}

	public KakugenItems(String genre_name, String kakugen_image, String kakugen_active) {
		super();
		this.genre_name = genre_name;
		this.kakugen_image = kakugen_image;
		this.kakugen_active = kakugen_active;
	}

	public KakugenItems(String mail) {
		super();
		this.mail = mail;
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

	public String getKakugen_id() {
		return kakugen_id;
	}

	public void setKakugen_id(String kakugen_id) {
		this.kakugen_id = kakugen_id;
	}

	public String getKakugen_active() {
		return kakugen_active;
	}

	public void setKakugen_active(String kakugen_active) {
		this.kakugen_active = kakugen_active;
	}

	public String getGenre_name() {
		return genre_name;
	}

	public void setKakugen_name(String genre_name) {
		this.genre_name = genre_name;
	}

	public String getKakugen_image() {
		return kakugen_image;
	}

	public void setKakugen_image(String kakugen_image) {
		this.kakugen_image = kakugen_image;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
