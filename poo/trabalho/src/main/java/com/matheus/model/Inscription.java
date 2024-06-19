package com.matheus.model;

import com.matheus.util.Id;

public class Inscription {
	private int id;
	private Inscription inscription;
	private Student student;
	private Clazz clazz;
	private double score;

	public Inscription(Student student, double score, Clazz clazz) {
		this.student = student;
		this.score = score;
		this.clazz = clazz;
	}
	
	@Id
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public Inscription getInscription() {return inscription;}
	public void setInscription(Inscription inscription) {this.inscription = inscription;}
	
	public Student getStudent() {return student;}
	public void setStudent(Student student) {this.student= student;}
	
	public Clazz getClazz() {return clazz;}
	public void setClazz(Clazz clazz) {this.clazz= clazz;}
	
	public double getScore() {return score;}
	public void setScore(double score) {this.score= score;}
	
	@Override
	public String toString() {
		return "Inscription{id=" + id + ", Student=" + student.getName() + ", Score=" + score + "}";
	}

}