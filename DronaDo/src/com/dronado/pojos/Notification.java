package com.dronado.pojos;

import java.util.Date;

public class Notification {
	
	protected int nId;
	protected java.util.Date date;
	protected int sender;
	protected int receiver;
	protected String message;
	protected String type;
	public Notification() {
		super();
	}
	public Notification(int nId, Date date, int sender, int receiver, String message, String type) {
		super();
		this.nId = nId;
		this.date = date;
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
		this.type = type;
	}
	public int getnId() {
		return nId;
	}
	public void setnId(int nId) {
		this.nId = nId;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public int getReceiver() {
		return receiver;
	}
	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + nId;
		result = prime * result + receiver;
		result = prime * result + sender;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notification other = (Notification) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (nId != other.nId)
			return false;
		if (receiver != other.receiver)
			return false;
		if (sender != other.sender)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Notification [nId=" + nId + ", date=" + date + ", sender=" + sender + ", receiver=" + receiver
				+ ", message=" + message + ", type=" + type + "]";
	}
	
	
}
