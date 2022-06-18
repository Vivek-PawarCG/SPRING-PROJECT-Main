package com.cg.loan.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login_page")
public class Login {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_Id", nullable = false)
	public String userId;

    @Column(name = "password", nullable = false)
	public String password;
  // @Length(min = 5, message = "*Your password must have at least 5 characters")
  // @NotEmpty(message = "*Please provide your password")
   // @JsonIgnore
 
    

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