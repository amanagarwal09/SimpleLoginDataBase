package com.example.model;

public class RegisterCompany {
	private int id;
	private String name;
	private String companyname;
	private long contact;
	private String gender;
	private String country;
	private String state;
	private String city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public RegisterCompany(int id, String name, String companyname, long contact, String gender, String country,
			String state, String city) {
		super();
		this.id = id;
		this.name = name;
		this.companyname = companyname;
		this.contact = contact;
		this.gender = gender;
		this.country = country;
		this.state = state;
		this.city = city;
	}

	public RegisterCompany() {
		super();
	}

	@Override
	public String toString() {
		return "RegisterCompany [id=" + id + ", name=" + name + ", companyname=" + companyname + ", contact=" + contact
				+ ", gender=" + gender + ", country=" + country + ", state=" + state + ", city=" + city + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
