package model;

import java.io.Serializable;

public class Kakugens implements Serializable{
	private int id;
	private String kakugen;
	private String genre_name;
	private String genre;
	private String kakugen_id;
	private int kakugen_point;
	private String kakugen_image;

	public Kakugens(int id, String kakugen, String genre_name, String genre,
			String kakugen_id, int kakugen_point, String kakugen_image) {
		this.id = id;
		this.kakugen= kakugen;
		this.genre_name= genre_name;
		this.genre = genre;
		this.kakugen_id= kakugen_id;
		this.kakugen_point= kakugen_point;
		this.kakugen_image= kakugen_image;

	}

	public Kakugens() {
		this.id = 0;
		this.kakugen= "";
		this.genre_name= "";
		this.genre = "";
		this.kakugen_id= "";
		this.kakugen_point= 0;
		this.kakugen_image="";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKakugen() {
		return kakugen;
	}

	public void setKakugen(String kakugen) {
		this.kakugen = kakugen;
	}

	public String getGenre_name() {
		return genre_name;
	}

	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getKakugen_id() {
		return kakugen_id;
	}

	public void setKakugen_id(String kakugen_id) {
		this.kakugen_id = kakugen_id;
	}

	public int getKakugen_point() {
		return kakugen_point;
	}

	public void setKakugen_point(int kakugen_point) {
		this.kakugen_point = kakugen_point;
	}

	public String getKakugen_image() {
		return kakugen_image;
	}

	public void setKakugen_image(String kakugen_image) {
		this.kakugen_image = kakugen_image;
	}


}
