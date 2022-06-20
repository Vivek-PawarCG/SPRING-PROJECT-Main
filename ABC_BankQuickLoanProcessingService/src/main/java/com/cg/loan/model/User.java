package com.cg.loan.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


//USER Database


	@Table(name = "loan_user") //Database Table
	@Entity
	@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
	@DiscriminatorColumn(name = "role_Type", discriminatorType = DiscriminatorType.INTEGER)
	@DiscriminatorValue(value = "1")
	public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_gen")
		private int userId;

		@NotEmpty(message = "Password can't be empty!")
		@Size(min = 8, max = 20, message = "Password has to be of minimum 8 chars!")
		
		private String password;

		@NotEmpty(message = "Role Type can't be empty!")
		@Size(min = 2, max = 14, message = "Invalid Role please enter a vaild Role!")
		@Pattern(regexp = ("^(user|admin|LADofficer|customer)$"), message = "INVALID Role PLEASE ENTER AGAIN")
		@Pattern(regexp = "^[a-zA-Z]*$", message = "Accepts only alphabets! re-enter the role")
		private String role;
		
		
        //New Mapping : User Id Mapped with Application Id
		@ManyToMany(cascade = CascadeType.ALL)
		@JoinTable(name = "user_loan", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "application_id") })
		private Set<LoanApplication> loan_application = new HashSet<>();

		
		public User() {

			super();

		}

		public User(int userId, String password, String role) {
			super();
			this.userId = userId;
			this.password = password;
			this.role = role;
		}

		public User(int userId) {
			super();
			this.userId = userId;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		@Override
		public String toString() {
			return "User [userId=" + userId + ", role=" + role + "]";
		}



	}


