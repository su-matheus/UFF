package com.matheus.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.matheus.util.Id;

public class Professor implements Serializable {
	private int id;
	private String name;
	private String email;
	private List<Clazz> clazzes;
	
	public Professor(String name, String email) {
		this.name = name;
		this.email = email;
		this.clazzes = new ArrayList<>();
	}
	
	@Id
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public List<Clazz> getClazzes() {return clazzes;}
	public void addClazz(Clazz clazz) {this.clazzes.add(clazz);}
	public void removeClazz(Clazz clazz) {this.clazzes.remove(clazz);}
	
	@Override
	public String toString() {
		return "Professor{id= " + id + ", name= " + name + ", email= " + email + ", classes= " + getClazzes() + "}";
	}

}
