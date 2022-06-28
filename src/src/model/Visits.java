package model;

import java.security.Timestamp;

public class Visits {
	private int id;
	private String user_id;
	private Timestamp visit_date;



	public Visits(int id, String user_id, Timestamp visit_date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.visit_date=visit_date;
	}

	public Visits(Timestamp visit_date) {
		super();
		this.visit_date=visit_date;
	}


	public Visits(String user_id) {
		super();
		this.user_id = user_id;
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

	public Timestamp getVisit_date() {
		return visit_date;
	}


	public void setVisit_date(Timestamp visit_date) {
		this.visit_date = visit_date;
	}

}
