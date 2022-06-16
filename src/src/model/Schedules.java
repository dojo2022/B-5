package model;
import java.io.Serializable;

public class Schedules implements Serializable{
	private int id;
	private String title;
	private String start_time;
	private String end_time;
	private String stamp_id;
	private String schedule_memo;
	private String place;
	private String user_id;

	public Schedules(int id, String title, String start_time, String end_time, String stamp_id,
			String schedule_memo, String place, String user_id) {
		super();
		this.id = id;
		this.title = title;
		this.start_time = start_time;
		this.end_time = end_time;
		this.stamp_id = stamp_id;
		this.schedule_memo = schedule_memo;
		this.place = place;
		this.user_id = user_id;
	}

	public Schedules() {
		this.id = 0;
		this.title = "";
		this.start_time = "";
		this.end_time = "";
		this.stamp_id = "";
		this.schedule_memo = "";
		this.place = "";
		this.user_id = "";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
 	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String  getStamp_id() {
		return stamp_id;
	}
	public void setStamp_id(String stamp_id) {
		this.stamp_id = stamp_id;
	}
	public String getSchedule_memo() {
		return schedule_memo;
	}
	public void setSchedule_memo(String schedule_memo) {
		this.schedule_memo = schedule_memo;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
