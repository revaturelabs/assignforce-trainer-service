package com.revature.assignforce.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "CERTS")
public class Cert {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cert")
	@SequenceGenerator(name = "cert", sequenceName = "cert_seq", allocationSize = 1)
	@Column(name = "CERT_ID")
	private int certId;

	@Column(name = "CERT_NAME")
	private String certName;

	public Cert() {

	}

	public Cert(int certId, String certName) {
		super();
		this.certId = certId;
		this.certName = certName;
	}

	public int getCertId() {
		return certId;
	}

	public void setCertId(int certId) {
		this.certId = certId;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}
	
}
