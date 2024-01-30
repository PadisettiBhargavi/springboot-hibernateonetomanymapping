package com.hibernateoneone;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Subject {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String name;
@OneToMany(mappedBy="subject",cascade=CascadeType.ALL)
private Set<ClassStudent> students;
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
public Set<ClassStudent> getStudents() {
	return students;
}
public void setStudents(Set<ClassStudent> students) {
	this.students = students;
}
@Override
public String toString() {
	return "Subject [id=" + id + ", name=" + name + ", students=" + students + ", getId()=" + getId() + ", getName()="
			+ getName() + ", getStudents()=" + getStudents() + "]";
}
public Subject(int id, String name, Set<ClassStudent> students) {
	super();
	this.id = id;
	this.name = name;
	this.students = students;
}

}
