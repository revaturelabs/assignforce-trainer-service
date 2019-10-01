package com.revature.assignforce.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.stereotype.Component;


@Entity
@Component
@Table(name = "TRAINER")
public class Trainer {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainer")
	@SequenceGenerator(name = "trainer", sequenceName = "trainer_seq", allocationSize = 1)
	@Column(name = "TRAINER_ID")
	private int id;

	@Column(name = "Firstname")
	private String firstName;

	@Column(name = "Lastname")
	private String lastName;

	@Column(name = "isActive")
	private Boolean isActive;

	@Column(name = "preferredLocation")
	private Integer preferredLocation;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "TRAINER_ID")
	private Set<Unavailability> unavailabilities;

	@Column(name = "email")
	private String email;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TRAIN_SKILLIDHOLDER", 
		joinColumns =  @JoinColumn(name = "TRAINER_ID") , 
		inverseJoinColumns = @JoinColumn(name = "SKILL_ID") )
	private Set<SkillIdHolder> skills;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
	@JoinTable(name = "CERT_TRAINERS", 
		joinColumns = @JoinColumn(name = "TRAINER_ID"), 
		inverseJoinColumns = @JoinColumn(name = "CERT_ID") )
	private Set<Cert> certifications;
	
	@Column(name = "RESUME") 
	private String resume;
	
	@Column(name = "LINKED_IN_URL")
	private String linkedInUrl;

	// To add: resume/ resume id in bitbucket

	public Trainer() {
		super();
	}

	public Trainer(int id, String firstName, String lastName, Boolean isActive, Integer preferredLocation,
			Set<Unavailability> unavailabilities, String email, Set<SkillIdHolder> skills, Set<Cert> certifications,
			String resume, String linkedInUrl) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isActive = isActive;
		this.preferredLocation = preferredLocation;
		this.unavailabilities = unavailabilities;
		this.email = email;
		this.skills = skills;
		this.certifications = certifications;
		this.resume = resume;
		this.linkedInUrl = linkedInUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getPreferredLocation() {
		return preferredLocation;
	}

	public void setPreferredLocation(Integer preferredLocation) {
		this.preferredLocation = preferredLocation;
	}

	public Set<Unavailability> getUnavailabilities() {
		return unavailabilities;
	}

	public void setUnavailabilities(Set<Unavailability> unavailabilities) {
		this.unavailabilities = unavailabilities;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<SkillIdHolder> getSkills() {
		return skills;
	}

	public void setSkills(Set<SkillIdHolder> skills) {
		this.skills = skills;
	}

	public Set<Cert> getCertifications() {
		return certifications;
	}

	public void setCertifications(Set<Cert> certifications) {
		this.certifications = certifications;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getLinkedInUrl() {
		return linkedInUrl;
	}

	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}

}
