package com.matheus.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.matheus.util.Id;

public class Inscription implements Serializable {
	private int id;
	private Inscription inscription;
	private Student student;
	private double score;
	private Presence presence;
	private String date;
	private List<Clazz> classes;

	
	public enum Presence  {
	    SUFFICIENT("Sufficient"),
	    UNSUFFICIENT("Unsufficient");
		private final String presencePhrase;

		Presence(String message) {
			this.presencePhrase = message;
		}
		
		public String getPhrase() {
			return presencePhrase;
		}
	}


	public Inscription(Student student, double score, Presence presence) {
		this.student = student;
		this.score = score;
		this.presence = presence;
		this.classes = new ArrayList<>();
	}
	
	@Id
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public Inscription getInscription() {return inscription;}
	public void setInscription(Inscription inscription) {this.inscription = inscription;}
	
	public Student getStudent() {return student;}
	public void setStudent(Student student) {this.student= student;}
		
	public double getScore() {return score;}
	public void setScore(double score) {this.score= score;}
	
	public Presence getPresence() {return presence;}
	public void setPresence(Presence presence) {this.presence = presence;}
	
	public String getDate() {return date;}
	public void setDate(String date) {this.date = date;}
	
	public List<Clazz> getClasses() {return classes;}
	public void addClazz(Clazz clazz) {this.classes.add(clazz);}
	public void removeClazz(Clazz clazz) {this.classes.remove(clazz);}

	@Override
	public String toString() {
		return "Inscription{id= " + id + ", Student= " + student.getName() + ", Score= " + score + ", presence= " + presence + ", date= " + getDate() + "}";
	}

}