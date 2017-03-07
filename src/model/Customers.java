package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customers
{
    @XmlElement(name = "customer")
    private List<Customer> customers = null;
 
    public List<Customer> getCustomers() {
        return customers;
    }
 
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

	@Override
	public String toString() {
		String str = "";
		for (Customer customer : getCustomers()) {
			str = str + "Customer [id=" + customer.getId() + ", firstName=" + customer.getFirstName() + ", lastName=" + customer.getLastName() + ", email=" + customer.getEmail()
					+ ", phoneNo=" + customer.getPhoneNo() + "]";
		}
		return "Customers [customers=" + customers + "]";
	}
    
}