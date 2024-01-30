package com.hibernateoneone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ClassStudent {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String name;
private String dob;
private String classes;
private String division;
private String gender;
@ManyToOne
@JoinColumn(name="subject_id")
private Subject subject;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getClasses() {
	return classes;
}
public void setClasses(String classes) {
	this.classes = classes;
}
public String getDivision() {
	return division;
}
public void setDivision(String division) {
	this.division = division;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public Subject getSubject() {
	return subject;
}
public void setSubject(Subject subject) {
	this.subject = subject;
}
@Override
public String toString() {
	return "ClassStudent [id=" + id + ", name=" + name + ", dob=" + dob + ", classes=" + classes + ", division="
			+ division + ", gender=" + gender + ", subject=" + subject + ", getId()=" + getId() + ", getName()="
			+ getName() + ", getDob()=" + getDob() + ", getClasses()=" + getClasses() + ", getDivision()="
			+ getDivision() + ", getGender()=" + getGender() + ", getSubject()=" + getSubject() + "]";
}
public ClassStudent(int id, String name, String dob, String classes, String division, String gender, Subject subject) {
	super();
	this.id = id;
	this.name = name;
	this.dob = dob;
	this.classes = classes;
	this.division = division;
	this.gender = gender;
	this.subject = subject;
}

}
