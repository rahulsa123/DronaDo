package com.dronado.pojos;

public class Student extends User{
	
	protected int studId;
	protected String studFullName;
	protected String studEmail;
	protected String studPhoneNo;
	protected String studAddress;
	protected int studAddressId;
	public Student() {
		super();
	}
	public Student(int studId, String studFullName, String studEmail, String studPhoneNo, String studAddress,
			int studAddressId) {
		super();
		this.studId = studId;
		this.studFullName = studFullName;
		this.studEmail = studEmail;
		this.studPhoneNo = studPhoneNo;
		this.studAddress = studAddress;
		this.studAddressId = studAddressId;
	}
	public Student( String studFullName, String studEmail, String studPhoneNo, String studAddress,
			int studAddressId) {
		super();
		this.studFullName = studFullName;
		this.studEmail = studEmail;
		this.studPhoneNo = studPhoneNo;
		this.studAddress = studAddress;
		this.studAddressId = studAddressId;
	}
	public Student( String username, String password, String usertype, String studFullName,
			String studEmail, String studPhoneNo, String studAddress, int studAddressId) {
		super(username, password, usertype);
		this.studFullName = studFullName;
		this.studEmail = studEmail;
		this.studPhoneNo = studPhoneNo;
		this.studAddress = studAddress;
		this.studAddressId = studAddressId;
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudFullName() {
		return studFullName;
	}
	public void setStudFullName(String studFullName) {
		this.studFullName = studFullName;
	}
	public String getStudEmail() {
		return studEmail;
	}
	public void setStudEmail(String studEmail) {
		this.studEmail = studEmail;
	}
	public String getStudPhoneNo() {
		return studPhoneNo;
	}
	public void setStudPhoneNo(String studPhoneNo) {
		this.studPhoneNo = studPhoneNo;
	}
	public String getStudAddress() {
		return studAddress;
	}
	public void setStudAddress(String studAddress) {
		this.studAddress = studAddress;
	}
	public int getStudAddressId() {
		return studAddressId;
	}
	public void setStudAddressId(int studAddressId) {
		this.studAddressId = studAddressId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((studAddress == null) ? 0 : studAddress.hashCode());
		result = prime * result + studAddressId;
		result = prime * result + ((studEmail == null) ? 0 : studEmail.hashCode());
		result = prime * result + ((studFullName == null) ? 0 : studFullName.hashCode());
		result = prime * result + studId;
		result = prime * result + ((studPhoneNo == null) ? 0 : studPhoneNo.hashCode());
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
		Student other = (Student) obj;
		if (studAddress == null) {
			if (other.studAddress != null)
				return false;
		} else if (!studAddress.equals(other.studAddress))
			return false;
		if (studAddressId != other.studAddressId)
			return false;
		if (studEmail == null) {
			if (other.studEmail != null)
				return false;
		} else if (!studEmail.equals(other.studEmail))
			return false;
		if (studFullName == null) {
			if (other.studFullName != null)
				return false;
		} else if (!studFullName.equals(other.studFullName))
			return false;
		if (studId != other.studId)
			return false;
		if (studPhoneNo == null) {
			if (other.studPhoneNo != null)
				return false;
		} else if (!studPhoneNo.equals(other.studPhoneNo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studFullName=" + studFullName + ", studEmail=" + studEmail
				+ ", studPhoneNo=" + studPhoneNo + ", studAddress=" + studAddress + ", studAddressId=" + studAddressId
				+ "]";
	}
	
	
	
}
