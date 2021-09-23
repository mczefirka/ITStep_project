package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String username;
	
	private String email;
	private String password;
	
    public User(String username, String email, String password) {
        this.setUsername(username);
//        this.setRole_id(role_id);
        this.setEmail(email);
        this.setPassword(password);
    }
    
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_roles", 
             joinColumns = { @JoinColumn(name = "user_id") }, 
             inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<Role>();
    
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "role_id", nullable = false)
//	private Role role;
	
    @Transient
    private String passwordConfirm;
}
