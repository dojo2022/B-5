package model;
import java.io.Serializable;

public class Schedules implements Serializable{
	private int id;
	private String title;
	private String schedule_date;
	private String start_time;
	private String end_time;
	private int stamp_id;
	private String schedule_memo;
	private String place;
	private String user_id;
	private String mail;

	//引数があるコンストラクタ
	public Schedules(int id, String title, String schedule_date, String start_time, String end_time, int stamp_id,
			String schedule_memo, String place, String user_id) {
		super();
		this.id = id;
		this.title = title;
		this.schedule_date = schedule_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.stamp_id = stamp_id;
		this.schedule_memo = schedule_memo;
		this.place = place;
		this.user_id = user_id;
//		this.mail= mail;
	}

	//引数がないコンストラクタ（デフォルトコンストラクタ）
		public Schedules() {
			super();
			this.id = 0;
			this.title = "";
			this.schedule_date="";
			this.start_time = "";
			this.end_time = "";
			this.stamp_id = 0;
			this.schedule_memo = "";
			this.place = "";
			this.user_id = "";
//			this.mail="";
		}

		//７つのコンストラクタ

		public Schedules(String title, String schedule_date, String start_time, String end_time, int stamp_id,
				String schedule_memo, String place) {
			super();
			this.title = title;
			this.schedule_date = schedule_date;
			this.start_time = start_time;
			this.end_time = end_time;
			this.stamp_id = stamp_id;
			this.schedule_memo = schedule_memo;
			this.place = place;
		}

		//８つのコンストラクタ
		public Schedules(String title, String schedule_date, String start_time, String end_time, int stamp_id,
				String schedule_memo, String place, String user_id) {
			super();
			this.user_id = user_id;
			this.title = title;
			this.schedule_date = schedule_date;
			this.start_time = start_time;
			this.end_time = end_time;
			this.stamp_id = stamp_id;
			this.schedule_memo = schedule_memo;
			this.place = place;

		}

		public Schedules(String mail) {
			super();
			this.mail = mail;

		}


		//ゲッターとセッター
		public String getSchedule_date() {
			return schedule_date;
		}

		public void setSchedule_date(String schedule_date) {
			this.schedule_date = schedule_date;
		}

	public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
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
	public int  getStamp_id() {
		return stamp_id;
	}
	public void setStamp_id(int stamp_id) {
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
