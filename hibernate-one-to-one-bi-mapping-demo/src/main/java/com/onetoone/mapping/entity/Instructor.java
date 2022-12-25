package com.onetoone.mapping.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
//	Adding instructor_detail_id as foreign key column to the instructor table.
//	cascade=CascadeType.ALL --> making changes to instructor makes changes to all the instructor details table
//	Like updating --> also updates instructorDetail
//	deleteing --> also deletes the related instructorDetail
//	save --> also saves instructor detail and attaches the instructor detail's primary key as foreign key to the instructor table.
//	@JoinColumn(name="instructor_detail_id", referencedColumnName = "id")
//	 we're joining the instructor_detail_id column to the instructor table.
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id", referencedColumnName = "id")
	private InstructorDetail instructorDetail;

	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Instructor() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}
	
}
