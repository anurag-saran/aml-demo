package com.redhat.aml.pig;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerProfile {

	String transtype;
	String spend;
	String id;
	String occu;
	String numtr;
	String avg;
	public String getTranstype() {
		return transtype;
	}

	@XmlElement
	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}
	public String getOccu() {
		return occu;
	}

	@XmlElement
	public void setOccu(String occu) {
		this.occu = occu;
	}
	public String getSpend() {
		return spend;
	}

	@XmlElement
	public void setSpend(String spend) {
		this.spend = spend;
	}
	public String getNumtr() {
		return numtr;
	}

	@XmlElement
	public void setNumtr(String numtr) {
		this.numtr = numtr;
	}
	public String getId() {
		return id;
	}

	@XmlElement
	public void setId(String id) {
		this.id = id;
	}
	public String getAvg() {
		return avg;
	}

	@XmlElement
	public void setAvg(String avg) {
		this.avg = avg;
	}
}
