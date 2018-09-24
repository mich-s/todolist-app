package com.michal.todolist.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="users")
public class TodoListUser {

	@NotEmpty(message="is required")
	@Id
	@Column(name="username")
	private String username;
	

	@NotEmpty(message="is required")
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private int enabled;

	@OneToMany(mappedBy="todoListUser", cascade=CascadeType.ALL)
	private List<TodoList> todoLists;
	
	
	public TodoListUser() {
	}

	public TodoListUser(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}


}
