package model;
import java.io.Serializable;

public class Points implements Serializable{
	private String id;
	private String user_id;
	private String point_value;

	public Points(String id, String user_id, String point_value) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.point_value = point_value;
	}
	//引数がないコンストラクタ（デフォルトコンストラクタ）
	public Points() {
		this.id = "";
		this.user_id = "";
		this.point_value ="";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setPw(String user_id) {
		this.user_id = user_id;
	}

	public String getPoint_value() {
		return point_value;
	}

	public void setPoint_value(String point_value) {
		this.point_value= point_value;
	}
}


