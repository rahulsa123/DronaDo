package com.dronado.pojos;

public class Subject {
	
	protected int sId;
	protected String sName;
	protected String sStandard;
	protected String sStream;
	public Subject() {
		super();
	}
	public Subject(int sid, String snmae, String sstandard, String sstream) {
		super();
		this.sId = sid;
		this.sName = snmae;
		this.sStandard = sstandard;
		this.sStream = sstream;
	}
	public int getSId() {
		return sId;
	}
	public void setSId(int sid) {
		this.sId = sid;
	}
	public String getSName() {
		return sName;
	}
	public void setSName(String snmae) {
		this.sName = snmae;
	}
	public String getSStandard() {
		return sStandard;
	}
	public void setSStandard(String sstandard) {
		this.sStandard = sstandard;
	}
	public String getSStream() {
		return sStream;
	}
	public void setSStream(String sstream) {
		this.sStream = sstream;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sId;
		result = prime * result + ((sName == null) ? 0 : sName.hashCode());
		result = prime * result + ((sStandard == null) ? 0 : sStandard.hashCode());
		result = prime * result + ((sStream == null) ? 0 : sStream.hashCode());
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
		Subject other = (Subject) obj;
		if (sId != other.sId)
			return false;
		if (sName == null) {
			if (other.sName != null)
				return false;
		} else if (!sName.equals(other.sName))
			return false;
		if (sStandard == null) {
			if (other.sStandard != null)
				return false;
		} else if (!sStandard.equals(other.sStandard))
			return false;
		if (sStream == null) {
			if (other.sStream != null)
				return false;
		} else if (!sStream.equals(other.sStream))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Subject [sId=" + sId + ", sname=" + sName + ", sStandard=" + sStandard + ", sStream=" + sStream + "]";
	}
	
	
}
