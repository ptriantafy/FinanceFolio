package com.financefolio.user;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.financefolio.dao.MemberDAO;
import com.financefolio.dao.PointsDAO;
import com.financefolio.dao.PremiumFeatureTokenDAO;
import com.financefolio.points.Points;
import com.financefolio.points.PointsRecord;
import com.financefolio.premiumfeatures.PremiumFeatureToken;
import com.financefolio.dao.FriendDAO;
import com.financefolio.dao.FriendRequestDAO;
import com.financefolio.social.Friend;
import com.financefolio.social.FriendRequest;
import com.financefolio.social.FriendRequestsList;
import com.financefolio.social.FriendsList;

public class Member extends User {

	private boolean premiumMember;
	private float income;
	private int category;
	private int houseArea;
	private int houseResidents;
	private FriendsList friends;
	private FriendRequestsList requestsList;
	private PointsRecord pointsRecord;
	private List<PremiumFeatureToken> tokens;
	
	public Member(int id, String name, boolean premiumMember, int category, float income, int houseArea,
			int houseResidents, Date date) {
		super(id, name, date);
		this.premiumMember = premiumMember;
		this.category = category;
		this.income = income;
		this.houseArea = houseArea;
		this.houseResidents = houseResidents;
		this.friends = new FriendsList();
		this.requestsList = new FriendRequestsList();
		this.pointsRecord = new PointsRecord(new ArrayList<>());
		this.tokens = new ArrayList<>();
	}

	public boolean giftTokenToFriend(Friend friend, PremiumFeatureToken token) {
		if(token.getTokenFor().getCost() > this.getPointsRecord().getCurrentTotal()) {
//			insufficient points to gift token
			return false;
		}
		PremiumFeatureTokenDAO pftDAO = new PremiumFeatureTokenDAO();
		String[] arg = new String[] {String.valueOf(friend.getId())};
		try {
			pftDAO.save(token, arg);
			this.adjustPoints(-1*token.getTokenFor().getCost(), "Gift to: "+friend.getName() + " Premium Feature Token: " + token.getTokenFor().getDescripiton());

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean buyToken(PremiumFeatureToken token) {
		if(token.getTokenFor().getCost() > this.getPointsRecord().getCurrentTotal()) {
//			insufficient points to buy token
			return false;
		}
		this.getTokens().add(token);
		PremiumFeatureTokenDAO pftDAO = new PremiumFeatureTokenDAO();
		String[] arg = new String[] {String.valueOf(this.getId())};
		try {
			pftDAO.save(token, arg);
			this.adjustPoints(-1*token.getTokenFor().getCost(), "Bought Premium Feature Token: " + token.getTokenFor().getDescripiton());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public void adjustPoints(int amount, String reason) {
		Points newPoints = new Points(-1, amount, new Timestamp(System.currentTimeMillis()), reason);
		PointsDAO pDAO = new PointsDAO();
		String[] arg = new String[] {String.valueOf(this.getId())};
		try {
			pDAO.save(newPoints, arg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.getPointsRecord().addToRecord(newPoints);
	}
	
	public List<Member> searchMember(String searchQuery) {
	    MemberDAO memberDAO = new MemberDAO();
	    List<Member> filteredMembersList = new ArrayList<>();
	    try {
	        List<Member> allMembersList = memberDAO.getAll(0).get();
	        for (Member mem : allMembersList) {
	            if (mem.getName().contains(searchQuery)) {
	                filteredMembersList.add(mem);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	    return filteredMembersList;
	}

	public void sendFriendRequest(FriendRequest fr) {
		FriendRequestDAO frDAO = new FriendRequestDAO();
		try {
			frDAO.save(fr, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void acceptFriendRequest(FriendRequest fr) {
//		setting chat id -1; DAO will take care of it
		Friend newFriend = new Friend(fr.getSenderId(), 1, -1, Date.valueOf(LocalDate.now()));
		FriendDAO fDAO = new FriendDAO();
		FriendRequestDAO frDAO = new FriendRequestDAO();
//		required arguments to save in database
		String[] friendship_args = new String[] {String.valueOf(this.getId()), String.valueOf(fr.getSenderSharingLevel())};
		try {
			fDAO.save(newFriend, friendship_args);
			frDAO.delete(fr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.friends.addFriend(newFriend);
		this.requestsList.deleteRequest(fr);
	}
	
	public void declineFriendRequest(FriendRequest fr) {
		FriendRequestDAO frDAO = new FriendRequestDAO();
		try {
			frDAO.delete(fr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.requestsList.deleteRequest(fr);
	}
	
	public FriendsList getFriends() {
		return friends;
	}

	public void setFriends(FriendsList friends) {
		this.friends = friends;
	}

	public FriendRequestsList getRequestsList() {
		return requestsList;
	}

	public void setRequestsList(FriendRequestsList requestsList) {
		this.requestsList = requestsList;
	}

	protected void displayMemberInfo() {
	    System.out.println("Premium Member: " + premiumMember);
	    System.out.println("Category:" + category);
	    if(income!=0) {
	    System.out.println("Income: " + income);
	    }	
	    if(houseArea!=0 && houseResidents!=0) {
	    System.out.println("Square Meters: " + houseArea);
	    System.out.println("Number of Residents: " + houseResidents);
	    }
	}
	
	
	public void updateHouseDetails(int area, int residents) {
		this.setHouseArea(area);
		this.setHouseResidents(residents);
	}

	
	public boolean isPremiumMember() {
		return premiumMember;
	}
	public void updateMembership(boolean membership) {
		this.premiumMember = membership;
	}
	public int getHouseResidents() {
		return houseResidents;
	}
	public void setHouseResidents(int houseResidents) {
		this.houseResidents = houseResidents;
	}
	public int getHouseArea() {
		return houseArea;
	}
	public void setHouseArea(int houseArea) {
		this.houseArea = houseArea;
	}
	public float getIncome() {
		return income;
	}
	public void updateIncome(float income) {
		this.income = income;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public PointsRecord getPointsRecord() {
		return pointsRecord;
	}

	public void setPointsRecord(PointsRecord pointsRecord) {
		this.pointsRecord = pointsRecord;
	}

	public List<PremiumFeatureToken> getTokens() {
		return tokens;
	}

	public void setTokens(List<PremiumFeatureToken> tokens) {
		this.tokens = tokens;
	}

	@Override
    public String toString() {
        return "\nid: " + String.valueOf(this.getId())+" name: " + this.getName()+" premium: " + String.valueOf(this.isPremiumMember())
        		+"\n Friends: " + this.getFriends().toString()
        		+"\n Friend Requests: " + this.getRequestsList();
    }
}


