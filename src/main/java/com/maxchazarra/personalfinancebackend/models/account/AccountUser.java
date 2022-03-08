package com.maxchazarra.personalfinancebackend.models.account;

import javax.persistence.*;

import com.maxchazarra.personalfinancebackend.models.User;

@Entity
@Table(name = "accounts_users")
public class AccountUser {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "account_id")
	private Account account;

	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
	private User user;

    @Enumerated(EnumType.STRING)
	@Column(length = 20,name="type")
	private EAccountPermission permission;

    @Column(nullable = false)
    private boolean isOwner = false;

    public AccountUser() {

    }

	public long getId() {
		return id;
	}
    
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

    public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    public EAccountPermission getPermission() {
		return this.permission;
	}

	public void setPermission(EAccountPermission permission) {
		this.permission = permission;
	}

    public boolean isOwner() {
		return this.isOwner;
	}

	public void setIsOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}

}
