package com.dronado.pojos;

import java.util.ArrayList;

public class Tutor extends User{
	protected int tuId;
	protected String tuFullName;
	protected String tuEmail;
	protected String tuPhoneNo;
	protected String tuAddress;
	protected String qualification;
	protected int tuAddressId;
	protected ArrayList<Integer> tuSubjects;
	
	public Tutor() {
		super();
	}

	
	public Tutor(int tuId,int uid, String tuFullName, String tuEmail, String tuPhoneNo, String tuAddress, String qualification,
			int tuAddressId) {
		super();
		this.tuId = tuId;
		this.tuFullName = tuFullName;
		this.tuEmail = tuEmail;
		this.tuPhoneNo = tuPhoneNo;
		this.tuAddress = tuAddress;
		this.qualification = qualification;
		this.tuAddressId = tuAddressId;
	}
public Tutor(String username,String password, String usertype, String tuFullName, String tuEmail, String tuPhoneNo, String tuAddress, String qualification,
		int tuAddressId) {
	super(username, password, usertype);
	this.tuFullName = tuFullName;
	this.tuEmail = tuEmail;
	this.tuPhoneNo = tuPhoneNo;
	this.tuAddress = tuAddress;
	this.qualification = qualification;
	this.tuAddressId = tuAddressId;
}
public Tutor( String tuFullName, String tuEmail, String tuPhoneNo, String tuAddress, String qualification,
		int tuAddressId) {
	super();
	this.tuFullName = tuFullName;
	this.tuEmail = tuEmail;
	this.tuPhoneNo = tuPhoneNo;
	this.tuAddress = tuAddress;
	this.qualification = qualification;
	this.tuAddressId = tuAddressId;
}

	public Tutor(int uid, String tufullname,
			String tuemail, String tuphoneno, String tuaddress, String qualification, int tuaddressid) {
		this.uId=uid;
		
		this.tuFullName = tufullname;
		this.tuEmail = tuemail;
		this.tuPhoneNo = tuphoneno;
		this.tuAddress = tuaddress;
		this.qualification = qualification;
		this.tuAddressId = tuaddressid;
	}

	public int getTuId() {
		return tuId;
	}

	public void setTuId(int tuId) {
		this.tuId = tuId;
	}

	public String getTuFullName() {
		return tuFullName;
	}

	public void setTuFullName(String tuFullName) {
		this.tuFullName = tuFullName;
	}

	public String getTuEmail() {
		return tuEmail;
	}

	public void setTuEmail(String tuEmail) {
		this.tuEmail = tuEmail;
	}

	public String getTuPhoneNo() {
		return tuPhoneNo;
	}

	public void setTuPhoneNo(String tuPhoneNo) {
		this.tuPhoneNo = tuPhoneNo;
	}

	public String getTuAddress() {
		return tuAddress;
	}

	public void setTuAddress(String tuAddress) {
		this.tuAddress = tuAddress;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getTuAddressId() {
		return tuAddressId;
	}

	public void setTuAddressId(int tuAddressId) {
		this.tuAddressId = tuAddressId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((qualification == null) ? 0 : qualification.hashCode());
		result = prime * result + ((tuAddress == null) ? 0 : tuAddress.hashCode());
		result = prime * result + tuAddressId;
		result = prime * result + ((tuEmail == null) ? 0 : tuEmail.hashCode());
		result = prime * result + ((tuFullName == null) ? 0 : tuFullName.hashCode());
		result = prime * result + tuId;
		result = prime * result + ((tuPhoneNo == null) ? 0 : tuPhoneNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tutor other = (Tutor) obj;
		if (qualification == null) {
			if (other.qualification != null)
				return false;
		} else if (!qualification.equals(other.qualification))
			return false;
		if (tuAddress == null) {
			if (other.tuAddress != null)
				return false;
		} else if (!tuAddress.equals(other.tuAddress))
			return false;
		if (tuAddressId != other.tuAddressId)
			return false;
		if (tuEmail == null) {
			if (other.tuEmail != null)
				return false;
		} else if (!tuEmail.equals(other.tuEmail))
			return false;
		if (tuFullName == null) {
			if (other.tuFullName != null)
				return false;
		} else if (!tuFullName.equals(other.tuFullName))
			return false;
		if (tuId != other.tuId)
			return false;
		if (tuPhoneNo == null) {
			if (other.tuPhoneNo != null)
				return false;
		} else if (!tuPhoneNo.equals(other.tuPhoneNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tutor [tuId=" + tuId + ", tuFullName=" + tuFullName + ", tuEmail=" + tuEmail + ", tuPhoneNo="
				+ tuPhoneNo + ", tuAddress=" + tuAddress + ", qualification=" + qualification + ", tuAddressId="
				+ tuAddressId + "]";
	}


	public ArrayList<Integer> getTuSubjects() {
		return tuSubjects;
	}


	public void setTuSubjects(ArrayList<Integer> tusubjects) {
		this.tuSubjects = tusubjects;
	}

	
	
	
}
