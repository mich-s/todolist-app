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
	
}
