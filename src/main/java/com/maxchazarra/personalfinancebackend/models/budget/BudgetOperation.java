package com.maxchazarra.personalfinancebackend.models.budget;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "budgets_operations")
public class BudgetOperation {

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
    @JoinColumn(name = "budget_id")
	private Budget budget;

    public BudgetOperation() {

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

    public Budget getBudget() {
		return this.budget;
	}

	public void setAccountCategory(Budget budget) {
		this.budget = budget;
	}

}
