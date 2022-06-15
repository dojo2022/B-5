package model;
import java.io.Serializable;

public class Points implements Serializable{
	private int id;
	private String user_id;
	private int point_value;

	public Points(int id, String user_id, int point_value) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.point_value = point_value;
	}
	//引数がないコンストラクタ（デフォルトコンストラクタ）
	public Points() {
		this.id = 0;
		this.user_id = "";
		this.point_value =0;
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

	public void setPw(String user_id) {
		this.user_id = user_id;
	}

	public int getPoint_value() {
		return point_value;
	}

	public void setPoint_value(int point_value) {
		this.point_value= point_value;
	}
}


