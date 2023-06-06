package com.financefolio.premiumfeatures;

import java.sql.Date;
import java.sql.SQLException;

import com.financefolio.dao.PremiumFeatureDAO;

public class PremiumFeatureToken {
	private int id;
	private PremiumFeature tokenFor;
	private Date receivedOn;
	
	public PremiumFeatureToken(int id, Date receivedOn, PremiumFeature tokenFor) {
		super();
		this.id = id;
		this.receivedOn = receivedOn;
		this.tokenFor = tokenFor;
	}
	public void fetchPremiumFeature(int id) {
		PremiumFeatureDAO pfDAO = new PremiumFeatureDAO();
		try {
			this.setTokenFor(pfDAO.get(id).get());
		} catch (Exception e) {
			this.setTokenFor(null);
			e.printStackTrace();
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getReceivedOn() {
		return receivedOn;
	}
	public void setReceivedOn(Date receivedOn) {
		this.receivedOn = receivedOn;
	}
	public PremiumFeature getTokenFor() {
		return tokenFor;
	}
	public void setTokenFor(PremiumFeature tokenFor) {
		this.tokenFor = tokenFor;
	}
	@Override
    public String toString() {
		return "\nid: " + String.valueOf(this.getId()) + " ReceivedOn: " + String.valueOf(this.getReceivedOn()) + " For: " + this.getTokenFor().getDescripiton() +"\n";
    }
}
