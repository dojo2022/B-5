package model;

import java.io.Serializable;

public class KakugenItems implements Serializable {
	public int id;
	public String user_id;
	public String kakugen_id;

	//引数があるコンストラクタ
	public KakugenItems(int id, String user_id, String kakugen_id) {
		super();
		this.id = id;
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

}
