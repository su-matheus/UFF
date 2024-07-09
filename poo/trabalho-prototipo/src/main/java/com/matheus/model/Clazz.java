package com.matheus.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.matheus.util.Id;

public class Clazz implements Serializable {
	private int id;
	private Integer year;
	private Integer period;
	private Professor professor;
	private Discipline discipline;
	private List<Inscription> inscriptions;
	
	public Clazz(Integer year, Integer period, Professor professor, Discipline discipline) {
		this.year = year;
		this.period = period;
		this.professor = professor;
		this.discipline = discipline;
		this.inscriptions = new ArrayList<>();
	}
	
	@Id
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public Integer getYear() {return year;}
	public void setYear(Integer year) {this.year = year;}
	
	public Integer getPeriod() {return period;}
	public void setPeriod(Integer period) {this.period = period;}
		
	public Professor getProfessor() {return professor;}
	public void setProfessor(Professor professor) {this.professor = professor;}
	
	public Discipline getDiscipline() {return discipline;}
	public void setDiscipline(Discipline discipline) {this.discipline = discipline;}
	
	public List<Inscription> getInscriptions() {return inscriptions;}
	public void addInscription(Inscription inscription) {this.inscriptions.add(inscription);}
	public void removeInscription(Inscription inscription) {this.inscriptions.remove(inscription);}
	
	@Override
	public String toString() {
		return "Class{id= " + id + ", year= " + year + ", period= " + period + ", professor= " + getProfessor().getName() + ", discipline= " + getDiscipline().getName() + ", inscriptions=" + getInscriptions() + "}";
	}
}
