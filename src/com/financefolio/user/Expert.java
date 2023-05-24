package com.financefolio.user;

public class Expert extends User {
	private int averageRating;
	private String speciality;
	
	public Expert(int id, String name, int averageRating, String speciality) {
		super(id, name);
		this.averageRating = averageRating;
		this.speciality = speciality;
	}
	
	public int getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(int averageRating) {
		this.averageRating = averageRating;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
}
