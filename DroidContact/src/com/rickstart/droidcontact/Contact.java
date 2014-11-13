package com.rickstart.droidcontact;

public class Contact {
	
	private String name;
	private String email;
	private String phone;
	private String facebook;
	private String twitter;
	
	public Contact(String name, String email, String phone, String facebook, String twitter){
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.facebook = facebook;
		this.twitter = twitter;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getFacebook() {
		return facebook;
	}


	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}


	public String getTwitter() {
		return twitter;
	}


	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}


	
	
	
	

}
