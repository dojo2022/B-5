package model;
import java.io.Serializable;

public class Schdule implements Serializable{
	private int id;
	private String title;
	private String start_time;
	private String end_time;
	private String stamp_id;
	private String schedule_memo;
	private String place;
	private String user_id;

<<<<<<< Updated upstream:src/src/model/Schedule.java
	public Schdule(int id, String title, String start_time, String end_time, int stamp_id,
=======
	public Schedule(int id, String title, String start_time, String end_time, String stamp_id,
>>>>>>> Stashed changes:src/src/model/Schedules.java
			String schedule_memo, String place, String user_id) {
		super();
		this.id = id;
@ -21,19 +21,19 @@ public class TodoLists implements Serializable{
	}

	public TodoLists() {
		this.id = "";
		this.id = 0;
<<<<<<< Updated upstream:src/src/model/Schedule.java
		this.todo_deadline = "";
		this.task = "";
		this.importance = "";
		this.importance = 0;
		this.todo_memo= "";
=======
		this.title = "";
		this.start_time = "";
		this.end_time = "";
		this.stamp_id = "";
		this.schedule_memo = "";
		this.place = "";
>>>>>>> Stashed changes:src/src/model/Schedules.java
		this.user_id = "";
	}


	public String getId() {
	public int getId() {
		return id;
	}
	public void setId(String id) {
	public void setId(int id) {
		this.id = id;
	}
<<<<<<< Updated upstream:src/src/model/Schedule.java
	public String getTodo_deadline() {
@ -48,25 +48,25 @@
	public void setTask(String task) {
		this.task = task;
=======
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
>>>>>>> Stashed changes:src/src/model/Schedules.java
	}
	public String getImportance() {
	public int getImportance() {
		return importance;
	}
	public void setImportance(String importance) {
	public void setImportance(int importance) {
		this.importance = importance;
	}
	public String getTodo_memo() {
		return todo_memo;
	}
	public void setTodo_memo(String todo_memo) {
		this.todo_memo = todo_memo;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


}

