package model;

import java.io.Serializable;

public class CharacterItems implements Serializable {
	public int id;
	public String user_id;
	public String character_id;
	public String mail;
	public String character_active;
	public String character_image;
	public String character_name;

	//引数があるコンストラクタ
	public CharacterItems(int id, String user_id, String character_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.character_id = character_id;
	}

	//登録用コンストラクタ
	public CharacterItems(String user_id, String character_id) {
		super();
		this.user_id = user_id;
		this.character_id = character_id;
	}

	//引数がないコンストラクタ
	public CharacterItems() {
		super();
		this.id = 0;
		this.user_id = "";
		this.character_id = "";
	}

	public CharacterItems(String mail) {
		super();
		this.mail = mail;

	}

	public CharacterItems(String character_name, String character_image, String character_active) {
		super();
		this.character_name = character_name;
		this.character_image = character_image;
		this.character_active = character_active;

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

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCharacter_active() {
		return character_active;
	}

	public void setCharacter_active(String character_active) {
		this.character_active = character_active;
	}

	public String getCharacter_image() {
		return character_image;
	}

	public void setCharacter_image(String character_image) {
		this.character_image = character_image;
	}

	public String getCharacter_name() {
		return character_name;
	}

	public void setCharacter_name(String character_name) {
		this.character_name = character_name;
	}


}
