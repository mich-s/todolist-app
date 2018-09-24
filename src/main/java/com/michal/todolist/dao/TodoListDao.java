package com.michal.todolist.dao;

import java.util.List;

import com.michal.todolist.entity.Task;
import com.michal.todolist.entity.TodoList;

public interface TodoListDao {

	public List<TodoList> getTodoLists(String username);
	public void addList(TodoList todoList);
	public void deleteList(int listId);
	public TodoList getTodoList(int listId);
	
	public void addTask(Task task);
	public void deleteTask(int taskId);
	public Task getTask(int taskId);
	public void updateTask(Task task);
	public void toggleDone(Task task, int taskDone);
}
