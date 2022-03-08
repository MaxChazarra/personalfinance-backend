package com.maxchazarra.personalfinancebackend.models.account;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

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

	@OneToMany(mappedBy="account")
	private Set<AccountUser> users = new HashSet<>();

	@OneToMany(mappedBy="account")
	private Set<AccountCategory> categories = new HashSet<>();

	public Account() {

	}

	public Account(String title, String description) {
		this.title = title;
		this.description = description;
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

	public Set<AccountUser> getAccounts() {
		return users;
	}

	public void setAccounts(Set<AccountUser> users) {
		this.users = users;
	}

	public Set<AccountCategory> getOperations() {
		return categories;
	}

	public void setOperations(Set<AccountCategory> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", title=" + title + ", desc=" + description + ", balance=" + balance + "]";
	}

}