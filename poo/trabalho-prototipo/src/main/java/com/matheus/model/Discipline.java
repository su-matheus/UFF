package com.matheus.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.matheus.util.Id;

public class Discipline implements Serializable {
	private int id;
	private String name;
	private Integer courseLoad;
	private List<Discipline> preRequesites;
	private List<Clazz> classes;
	
	
	public Discipline(String name, Integer courseLoad) {
		this.name = name;
		this.courseLoad = courseLoad;
		this.preRequesites = new ArrayList<>();
		this.classes = new ArrayList<>();
	}
	
	@Id
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public Integer getCourseLoad() {return courseLoad;}
	public void setCourseLoad(int courseLoad) {this.courseLoad= courseLoad;}
	
	public List<Discipline> getPreRequisites() {return preRequesites;}
	public void addPrerequisite(Discipline discipline) {this.preRequesites.add(discipline);}
	public void removePrerequisite(Discipline discipline) {this.preRequesites.remove(discipline);}
	
	public List<Clazz> getClasses()	{return classes;}
	public void addClass(Clazz clazz) {this.classes.add(clazz);}
	public void removeClass(Clazz clazz) {this.classes.remove(clazz);}

	
	@Override
	public String toString() {
		return "Discipline {id= " + id + ", name= " + name + ", couse load= " + courseLoad + ", prerequisites= " + getPreRequisites() + "}";
		//studentService.getAllStudents().values().forEach(System.out::println);

	}
}
