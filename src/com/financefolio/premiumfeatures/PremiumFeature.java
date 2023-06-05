package com.financefolio.premiumfeatures;

public class PremiumFeature {
	private int id;
	private int cost;
	private String descripiton;
	
	public PremiumFeature(int id, int cost, String descripiton) {
		super();
		this.id = id;
		this.cost = cost;
		this.descripiton = descripiton;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getDescripiton() {
		return descripiton;
	}
	public void setDescripiton(String descripiton) {
		this.descripiton = descripiton;
	}
}
