package com.cg.loan.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//LOGIN Database

@Entity
@Table(name = "login_page")
public class Login {

    @Id
    @Column(name = "user_Id", nullable = false)
	public String userId;

    @Column(name = "password", nullable = false)
	public String password;
   
 
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    

}