package com.financefolio.user;

import java.util.Date;


public class Review {
	    private String body;
	    private String author;
	    private Date date;
	    private int rating;
	    private Expert expert;

	    public Review(String body, String author, Date date, int rating, Expert expert) {
	        this.body = body;
	        this.author = author;
	        this.date = date;
	        this.rating = rating;
	        this.expert = expert;
	    }

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		public Expert getExpert() {
			return expert;
		}

		public void setExpert(Expert expert) {
			this.expert = expert;
		}


	   
	}

