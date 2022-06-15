package model;

import java.io.Serializable;

public class Backgrounds implements Serializable {
	private int id;
	private String bg_name;
	private String bg_image;
	private int bg_point;
	private String background_id;

	public Backgrounds(int id, String bg_name, String bg_image, int bg_point, String background_id) {
		super();
		this.id = id;
		this.bg_name = bg_name;
		this.bg_image = bg_image;
		this.bg_point = bg_point;
		this.background_id = background_id;
	}

	public Backgrounds() {
		super();
		this.id = 0;
		this.bg_name ="";
		this.bg_image = "";;
		this.bg_point = 0;
		this.background_id = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getBg_point() {
		return bg_point;
	}

	public void setBg_point(int bg_point) {
		this.bg_point = bg_point;
	}

	public String getBackground_id() {
		return background_id;
	}

	public void setBackground_id(String background_id) {
		this.background_id = background_id;
	}


}
