package com.maxchazarra.personalfinancebackend.models.account;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "accounts_categories")
public class AccountCategory {
   
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    
    @Column(name = "title")
	private String title;

    @Enumerated(EnumType.STRING)
	@Column(length = 20,name="type")
	private EAccountCategoryType type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
	private Account account;

	@OneToMany(mappedBy="accountCategory")
	private Set<AccountOperation> operations = new HashSet<>();

    public AccountCategory() {

    }

    public long getId() {
		return id;
	}

    public EAccountCategoryType getType() {
		return type;
	}

	public void setType(EAccountCategoryType type) {
		this.type = type;
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

	public Set<AccountOperation> getOperations() {
		return operations;
	}

	public void setOperations(Set<AccountOperation> operations) {
		this.operations = operations;
	}

}
