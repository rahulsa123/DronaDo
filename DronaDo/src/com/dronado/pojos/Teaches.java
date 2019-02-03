package com.dronado.pojos;

public class Teaches {
	
	protected int tId;
	protected int sId;
	protected int tuId;
	protected float fees;
	protected String duration;
	protected String tAddress;
	protected int tAddressId;
	protected String experience;
	public Teaches() {
		super();
	}
	public Teaches(int tId, int sId, int tuId, float fees, String duration, String tAddress, int tAddressId,
			String experience) {
		super();
		this.tId = tId;
		this.sId = sId;
		this.tuId = tuId;
		this.fees = fees;
		this.duration = duration;
		this.tAddress = tAddress;
		this.tAddressId = tAddressId;
		this.experience = experience;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public int getTuId() {
		return tuId;
	}
	public void setTuId(int tuId) {
		this.tuId = tuId;
	}
	public float getFees() {
		return fees;
	}
	public void setFees(float fees) {
		this.fees = fees;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String gettAddress() {
		return tAddress;
	}
	public void settAddress(String tAddress) {
		this.tAddress = tAddress;
	}
	public int gettAddressId() {
		return tAddressId;
	}
	public void settAddressId(int tAddressId) {
		this.tAddressId = tAddressId;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((experience == null) ? 0 : experience.hashCode());
		result = prime * result + Float.floatToIntBits(fees);
		result = prime * result + sId;
		result = prime * result + ((tAddress == null) ? 0 : tAddress.hashCode());
		result = prime * result + tAddressId;
		result = prime * result + tId;
		result = prime * result + tuId;
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
		Teaches other = (Teaches) obj;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (experience == null) {
			if (other.experience != null)
				return false;
		} else if (!experience.equals(other.experience))
			return false;
		if (Float.floatToIntBits(fees) != Float.floatToIntBits(other.fees))
			return false;
		if (sId != other.sId)
			return false;
		if (tAddress == null) {
			if (other.tAddress != null)
				return false;
		} else if (!tAddress.equals(other.tAddress))
			return false;
		if (tAddressId != other.tAddressId)
			return false;
		if (tId != other.tId)
			return false;
		if (tuId != other.tuId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Teaches [tId=" + tId + ", sId=" + sId + ", tuId=" + tuId + ", fees=" + fees + ", duration=" + duration
				+ ", tAddress=" + tAddress + ", tAddressId=" + tAddressId + ", experience=" + experience + "]";
	}
	
	
}
