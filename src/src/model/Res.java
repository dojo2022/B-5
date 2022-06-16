package model;

import java.io.Serializable;

public class Res implements Serializable {
	private String title;		// タイトル


	public Res() {
		this(null);
	}

	public Res(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}