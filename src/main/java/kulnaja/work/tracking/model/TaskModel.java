package kulnaja.work.tracking.model;

import java.io.Serializable;

public class TaskModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3708965002893729543L;
	
	int taskId;
	String name;
	String value;
	String createDate;
	String updateDate;
	
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}
