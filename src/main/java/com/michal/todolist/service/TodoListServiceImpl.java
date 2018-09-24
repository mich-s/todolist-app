package com.michal.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.michal.todolist.dao.TodoListDao;
import com.michal.todolist.entity.Task;
import com.michal.todolist.entity.TodoList;

@Service
public class TodoListServiceImpl implements TodoListService {

	@Autowired
	private TodoListDao todoListDao;
	
	//Lists

	@Override
	@Transactional
	public List<TodoList> getTodoLists(String username) {
		return todoListDao.getTodoLists(username);
	}

	@Override
	@Transactional
	public void addList(TodoList todoList) {
		todoListDao.addList(todoList);
		
	}

	@Override
	@Transactional
	public void deleteList(int listId) {
		todoListDao.deleteList(listId);
		
	}

	@Override
	@Transactional
	public TodoList getTodoList(int listId) {
		return todoListDao.getTodoList(listId);
	}

	
	//Tasks
	
	@Override
	@Transactional
	public void addTask(Task task) {
		todoListDao.addTask(task);
	}

	@Override
	@Transactional
	public void deleteTask(int taskId) {
		todoListDao.deleteTask(taskId);
	}

	@Override
	@Transactional
	public Task getTask(int taskId) {
		return todoListDao.getTask(taskId);
	}

	@Override
	@Transactional
	public void updateTask(Task task) {
		todoListDao.updateTask(task);
	}

	@Override
	@Transactional
	public void toggleDone(Task task, int taskDone) {
		todoListDao.toggleDone(task, taskDone);
		
	}
	
	

}
