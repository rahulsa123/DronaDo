package com.dronado.pojos;

public class User {
	protected int uId;
	protected String username;
	protected String password;
	protected String userType;
	
	public User() {
		super();
	}

	public User(int uid, String username, String password, String usertype) {
		super();
		this.uId = uid;
		this.username = username;
		this.password = password;
		this.userType = usertype;
	}

	public User(String username, String password, String usertype) {
		super();
		this.username = username;
		this.password = password;
		this.userType = usertype;
	}

	public int getUId() {
		return uId;
	}

	public void setUId(int uid) {
		this.uId = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String usertype) {
		this.userType = usertype;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + uId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
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
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (uId != other.uId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", username=" + username + ", password=" + password + ", userType=" + userType
				+ "]";
	}
	
	

}
