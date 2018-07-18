package com.revature.assignforce.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "UNAVAILABILITY")
public class Unavailability {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unavailable")
	@SequenceGenerator(name = "unavailable", sequenceName = "unavailable_seq", allocationSize = 1)
	@Column(name = "UNAVAILABLEID")
	private int id;

	@Column(name = "START_DATE")
	private Timestamp startDate;

	@Column(name = "END_DATE")
	private Timestamp endDate;

	@Column(name = "DESCRIPTION")
	private String description;

	public Unavailability() {
		super();
	}

	public Unavailability(int id, Timestamp startDate, Timestamp endDate, String description) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
