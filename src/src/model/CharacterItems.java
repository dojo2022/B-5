package model;

import java.io.Serializable;

public class CharacterItems implements Serializable {
	public int id;
	public String user_id;
	public String character_id;

	//引数があるコンストラクタ
	public CharacterItems(int id, String user_id, String character_id) {
		super();
		this.id = id;
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
}
