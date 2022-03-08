package com.maxchazarra.personalfinancebackend.models.account;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "accounts_operations")
public class AccountOperation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @Column(name = "amount")
	private double amount;

    @Column(name = "title")
	private String title;

	@Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountcategory_id")
	private AccountCategory accountCategory;

    public AccountOperation() {

    }
    
	public long getId() {
		return id;
	}

    public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

    public AccountCategory getAccountCategory() {
		return this.accountCategory;
	}

	public void setAccountCategory(AccountCategory accountCategory) {
		this.accountCategory = accountCategory;
	}

}
