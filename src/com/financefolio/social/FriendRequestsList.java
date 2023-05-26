package com.financefolio.social;

import java.util.ArrayList;
import java.util.List;

public class FriendRequestsList {
	private List<FriendRequest> requests;

	public FriendRequestsList() {
		super();
		this.requests = new ArrayList<>();
	}
	
	public List<FriendRequest> getRequests(){
		return this.requests;
	}
	
	public FriendRequest getRequestById(int id) {
		for (FriendRequest fr : this.requests) {
			 if (fr.getRequestId() == id) return fr;
        }
		return null;
	}
	
	public void deleteRequest(FriendRequest fr) {
		this.requests.remove(fr);
	}
	public void addRequest(FriendRequest fr) {
		this.requests.add(fr);
	}
}
