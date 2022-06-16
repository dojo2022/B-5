package model;

import java.io.Serializable;

public class BackgroundItems implements Serializable {
	private int id;
	private String user_id;
	private String background_id;


	//引数があるコンストラクタ
	public BackgroundItems(int id, String user_id, String background_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.background_id = background_id;
	}

	//登録用コンストラクタ
	public BackgroundItems(String user_id, String background_id) {
		super();
		this.user_id = user_id;
		this.background_id = background_id;
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



}



