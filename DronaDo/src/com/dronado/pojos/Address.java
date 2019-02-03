package com.dronado.pojos;

public class Address {
	protected int addressId;
	protected float latitude;
	protected float longitude;
	
	public Address() {
		super();
	}

	public Address(int addressId, float latitude, float longitude) {
		super();
		this.addressId = addressId;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Address(float latitude, float longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressId;
		result = prime * result + Float.floatToIntBits(latitude);
		result = prime * result + Float.floatToIntBits(longitude);
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
		Address other = (Address) obj;
		if (addressId != other.addressId)
			return false;
		if (Float.floatToIntBits(latitude) != Float.floatToIntBits(other.latitude))
			return false;
		if (Float.floatToIntBits(longitude) != Float.floatToIntBits(other.longitude))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	
}
