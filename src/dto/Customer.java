package dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.thoughtworks.xstream.annotations.XStreamAlias;
//@XmlSeeAlso(ArrayList.class)
@XStreamAlias("customer")
@XmlRootElement(name="customer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id","firstName","lastName","email","phoneNo"})
public class Customer {
	private int id = 0;
	private String firstName, lastName, email, phoneNo = null;

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

//	@XmlElement
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

//	@XmlElement
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

//	@XmlElement
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNo=" + phoneNo + "]";
	}

}
