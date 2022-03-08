package com.maxchazarra.personalfinancebackend.models.account;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "balance")
	private double balance;

	@JsonIgnore
	@OneToMany(mappedBy="account", fetch=FetchType.EAGER)
	private Set<AccountUser> users = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy="account", fetch=FetchType.EAGER)
	private Set<AccountCategory> categories = new HashSet<>();

	public Account() {

	}

	public Account(String title, String description, double balance) {
		this.title = title;
		this.description = description;
		this.balance = balance;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Set<AccountUser> getUsers() {
		return users;
	}

	public void setUsers(Set<AccountUser> users) {
		this.users = users;
	}

	public Set<AccountCategory> getCategories() {
		return categories;
	}

	public void setCategories(Set<AccountCategory> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", title=" + title + ", desc=" + description + ", balance=" + balance + "]";
	}

}