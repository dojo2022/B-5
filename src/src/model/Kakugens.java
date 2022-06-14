package model;

import java.io.Serializable;

public class Kakugens implements Serializable{
	private String id;
	private String kakugen;
	private String genre_name;
	private String genre;
	private String kakugen_id;
	private String kakugen_point;

	public Kakugens(String id, String kakugen, String kakugen_name, String genre_name, String genre,
			String kakugen_id, String kakugen_point) {
		this.id = id;
		this.kakugen= kakugen;
		this.genre_name= genre_name;
		this.genre = genre;
		this.kakugen_id= kakugen_id;
		this.kakugen_point= kakugen_point;

	}

	public Kakugens() {
		this.id = "";
		this.kakugen= "";
		this.genre_name= "";
		this.genre = "";
		this.kakugen_id= "";
		this.kakugen_point= "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getKakugen_point() {
		return kakugen_point;
	}

	public void setKakugen_point(String kakugen_point) {
		this.kakugen_point = kakugen_point;
	}

}
