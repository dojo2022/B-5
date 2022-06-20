package model;
import java.io.Serializable;

public class TodoLists implements Serializable{
	private String id;
	private String todo_deadline;
	private String task;
	private String importance;
	private String todo_memo;
	private String user_id;

	public TodoLists(String id, String todo_deadline, String task, String importance, String todo_memo,
			String user_id) {
		super();
		this.id = id;
		this.todo_deadline = todo_deadline;
		this.task = task;
		this.importance = importance;
		this.todo_memo = todo_memo;
		this.user_id = user_id;
	}

	public TodoLists() {
		this.id = "";
		this.todo_deadline = "";
		this.task = "";
		this.importance = "";
		this.todo_memo= "";
		this.user_id = "";
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTodo_deadline() {
		return todo_deadline;
	}
	public void setTodo_deadline(String todo_deadline) {
		this.todo_deadline = todo_deadline;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getImportance() {
		return importance;
	}
	public void setImportance(String importance) {
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
