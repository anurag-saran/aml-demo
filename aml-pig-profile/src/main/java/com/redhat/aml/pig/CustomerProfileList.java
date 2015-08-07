package com.redhat.aml.pig;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(namespace = "aml.redhat.xml.jaxb.model")
public class CustomerProfileList{

// XmlElement sets the name of the entities

private ArrayList<CustomerProfile> customerList;

@XmlElementWrapper(name = "CustList")
@XmlElement(name = "customer")
public void setCustomerList(ArrayList<CustomerProfile> customerList) {
    this.customerList = customerList;
  }

  public ArrayList<CustomerProfile> getCustomerList() {
    return customerList;
  }

}

