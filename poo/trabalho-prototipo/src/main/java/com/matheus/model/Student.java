package com.matheus.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.matheus.util.Id;

public class Student implements Serializable {
	private int id;
	private String name;
	private String email;
	private List<Inscription> inscriptions;
	
	public Student(String name, String email) {
		this.name = name;
		this.email = email;
		this.inscriptions = new ArrayList<>();
	}
	
	@Id
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public List<Inscription> getInscriptions() {return inscriptions;}
	public void addInscription(Inscription inscription) {this.inscriptions.add(inscription);}
	public void removeInscription(Inscription inscription) {this.inscriptions.remove(inscription);}
	
	@Override
	public String toString() {
		return "Student{id= " + id + ", name= " + name + ", email= " + email + "}";
	}
}