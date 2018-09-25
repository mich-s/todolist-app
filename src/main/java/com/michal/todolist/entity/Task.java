package com.michal.todolist.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Task {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="task")
	private String task;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name="list_id")
	private TodoList todoList;
	
	@Column(name="done")
	private int done =0;
	
	
	public Task() {
		
	}
	

	public Task(String task, TodoList todoList) {
		this.task = task;
		this.todoList = todoList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public TodoList getTodoList() {
		return todoList;
	}

	public void setTodoList(TodoList todoList) {
		this.todoList = todoList;
	}

	public int getDone() {
		return done;
	}

	public void setDone(int done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", task=" + task + ", done=" + done + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + done;
		result = prime * result + id;
		result = prime * result + ((task == null) ? 0 : task.hashCode());
		result = prime * result + ((todoList == null) ? 0 : todoList.hashCode());
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
		Task other = (Task) obj;
		if (done != other.done)
			return false;
		if (id != other.id)
			return false;
		if (task == null) {
			if (other.task != null)
				return false;
		} else if (!task.equals(other.task))
			return false;
		if (todoList == null) {
			if (other.todoList != null)
				return false;
		} else if (!todoList.equals(other.todoList))
			return false;
		return true;
	}
	
	
	
	
	
}
