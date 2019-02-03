package com.dronado.pojos;

import java.util.Date;

public class Assigned {
	protected int aId;
	protected int studId;
	protected int tId;
	protected java.util.Date dateOfJoining;
	public Assigned() {
		super();
	}
	public Assigned(int aId, int studId, int tId, Date dateOfJoining) {
		super();
		this.aId = aId;
		this.studId = studId;
		this.tId = tId;
		this.dateOfJoining = dateOfJoining;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public java.util.Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(java.util.Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aId;
		result = prime * result + ((dateOfJoining == null) ? 0 : dateOfJoining.hashCode());
		result = prime * result + studId;
		result = prime * result + tId;
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
		Assigned other = (Assigned) obj;
		if (aId != other.aId)
			return false;
		if (dateOfJoining == null) {
			if (other.dateOfJoining != null)
				return false;
		} else if (!dateOfJoining.equals(other.dateOfJoining))
			return false;
		if (studId != other.studId)
			return false;
		if (tId != other.tId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Assigned [aId=" + aId + ", studId=" + studId + ", tId=" + tId + ", dateOfJoining=" + dateOfJoining
				+ "]";
	}
	
	
}
