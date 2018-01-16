package com.account;

public class TaskBean {
	private String name,description,dueDate,tagLine,status,cre_Date;
    private int priority;
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cre_Date == null) ? 0 : cre_Date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + priority;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tagLine == null) ? 0 : tagLine.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof TaskBean)) {
			return false;
		}
		TaskBean other = (TaskBean) obj;
		if (cre_Date == null) {
			if (other.cre_Date != null) {
				return false;
			}
		} else if (!cre_Date.equals(other.cre_Date)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (dueDate == null) {
			if (other.dueDate != null) {
				return false;
			}
		} else if (!dueDate.equals(other.dueDate)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (priority != other.priority) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		if (tagLine == null) {
			if (other.tagLine != null) {
				return false;
			}
		} else if (!tagLine.equals(other.tagLine)) {
			return false;
		}
		return true;
	}

}
