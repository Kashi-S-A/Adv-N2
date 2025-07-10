package com.ty;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

//composite key
@Embeddable
public class EmployeeId implements Serializable {

	private String email;
	private long phone;

	@Override
	public int hashCode() {
		return Objects.hash(email, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeId other = (EmployeeId) obj;
		return Objects.equals(email, other.email) && phone == other.phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

}
