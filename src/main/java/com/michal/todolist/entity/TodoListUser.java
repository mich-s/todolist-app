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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + enabled;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((todoLists == null) ? 0 : todoLists.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TodoListUser other = (TodoListUser) obj;
		if (enabled != other.enabled)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (todoLists == null) {
			if (other.todoLists != null)
				return false;
		} else if (!todoLists.equals(other.todoLists))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	
}
