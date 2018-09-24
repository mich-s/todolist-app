package com.michal.todolist.dao;

import java.util.List;
//import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.michal.todolist.entity.Task;
import com.michal.todolist.entity.TodoList;

@Repository
public class TodoListDaoImpl implements TodoListDao {

	@Autowired
	private SessionFactory sessionFactory;
	
//	private Logger logger = Logger.getLogger(getClass().getName());

	//Lists
	
	@Override
	public List<TodoList> getTodoLists(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<TodoList> query = currentSession.createQuery("from TodoList where todoListUser.username =: username", TodoList.class);
		query.setParameter("username", username);
		List<TodoList> todoLists2 = query.getResultList();
		
		return todoLists2;
	}

	@Override
	public void addList(TodoList todoList) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(todoList);
	}

	@Override
	public void deleteList(int listId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from TodoList where id=:listId");
		query.setParameter("listId", listId);
		query.executeUpdate();
		
	}

	@Override
	public TodoList getTodoList(int listId) {
		Session currentSession = sessionFactory.getCurrentSession();
		TodoList todoList = currentSession.get(TodoList.class, listId);
		
		return todoList;
	}

	//Tasks
	
	@Override
	public void addTask(Task task) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(task);
	}
	
	@Override
	public void deleteTask(int taskId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Task where id=:taskId");
		query.setParameter("taskId", taskId);
		query.executeUpdate();
	}

	@Override
	public Task getTask(int taskId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Task task = currentSession.get(Task.class, taskId);
		return task;
	}

	@Override
	public void updateTask(Task task) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("update Task set task=:taskName where id=:taskId");
		query.setParameter("taskName", task.getTask());
		query.setParameter("taskId", task.getId());
		query.executeUpdate();
	}

	@Override
	public void toggleDone(Task task, int taskDone) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("update Task set done=:done where id=:taskId");
		query.setParameter("done", taskDone);
		query.setParameter("taskId", task.getId());
		query.executeUpdate();
	}
	
	
}
