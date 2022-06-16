package model;
import java.io.Serializable;

public class Schdule implements Serializable{
	private int id;
	private String title;
	private String start_time;
	private String end_time;
	private int stamp_id;
	private String schedule_memo;
	private String place;
	private String user_id;

	public Schdule(int id, String title, String start_time, String end_time, int stamp_id,
			String schedule_memo, String place, String user_id) {
		super();
		this.id = id;
@ -21,19 +21,19 @@ public class TodoLists implements Serializable{
	}

	public TodoLists() {
		this.id = "";
		this.id = 0;
		this.todo_deadline = "";
		this.task = "";
		this.importance = "";
		this.importance = 0;
		this.todo_memo= "";
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
	public String getTodo_deadline() {
@ -48,25 +48,25 @@
	public void setTask(String task) {
		this.task = task;
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

