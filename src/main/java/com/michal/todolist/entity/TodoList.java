package com.michal.todolist.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lists")
public class TodoList {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="user_username")
	private TodoListUser todoListUser;
	
	
	@OneToMany(mappedBy="todoList", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Task> tasks;
	
	
	public TodoList() {
		
	}

	public TodoList(String name, TodoListUser todoListUser) {
		this.name = name;
		this.todoListUser = todoListUser; 
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TodoListUser getTodoListUser() {
		return todoListUser;
	}

	public void setTodoListUser(TodoListUser todoListUser) {
		this.todoListUser = todoListUser;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	@Override
	public String toString() {
		return "TodoList [id=" + id + ", name=" + name + ", todoListUser=" + todoListUser + ", tasks=" + tasks + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
		result = prime * result + ((todoListUser == null) ? 0 : todoListUser.hashCode());
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
		TodoList other = (TodoList) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tasks == null) {
			if (other.tasks != null)
				return false;
		} else if (!tasks.equals(other.tasks))
			return false;
		if (todoListUser == null) {
			if (other.todoListUser != null)
				return false;
		} else if (!todoListUser.equals(other.todoListUser))
			return false;
		return true;
	}

	
}
