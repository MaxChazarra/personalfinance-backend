package com.maxchazarra.personalfinancebackend.models.budget;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.maxchazarra.personalfinancebackend.models.account.Account;

@Entity
@Table(name = "budgets")
public class Budget {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    
    @Column(name = "title")
	private String title;

    @Column(name = "year")
	private int year;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
	private Account account;

    @OneToMany(mappedBy="budget")
	private Set<BudgetOperation> operations = new HashSet<>();

    public long getId() {
		return id;
	}

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

    public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

    public Set<BudgetOperation> getOperations() {
		return operations;
	}

	public void setOperations(Set<BudgetOperation> operations) {
		this.operations = operations;
	}

}
